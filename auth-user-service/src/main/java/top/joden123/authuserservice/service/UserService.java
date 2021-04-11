/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.joden123.authuserservice.domain.dto.UserLoginDTO;
import top.joden123.authuserservice.domain.entity.JWT;
import top.joden123.authuserservice.domain.entity.User;
import top.joden123.authuserservice.exception.UserLoginException;
import top.joden123.authuserservice.feign.AuthServiceFeign;
import top.joden123.authuserservice.repository.UserRepository;
import top.joden123.authuserservice.utils.BPwdEncoderUtil;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/10
 *
 * @author xiaofeng.he
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthServiceFeign authServiceFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User insertUser(String username, String  password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }

    public UserLoginDTO login(String username, String password){
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){
            throw new UserLoginException("error password");
        }
        // 获取token
        JWT jwt = authServiceFeign.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, password);
        // 获得用户菜单
        if(jwt == null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;

    }
}
