/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.joden123.authuserservice.domain.dto.UserLoginDTO;
import top.joden123.authuserservice.domain.entity.User;
import top.joden123.authuserservice.service.UserService;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User postUser(@RequestParam("username") String username, @RequestParam("password") String password){
        //参数判断，省略
        return userService.insertUser(username,password);
    }

    @PostMapping("/login")
    public UserLoginDTO login(@RequestParam("username") String username, @RequestParam("password") String password){
        //参数判断，省略
        return userService.login(username,password);
    }
}
