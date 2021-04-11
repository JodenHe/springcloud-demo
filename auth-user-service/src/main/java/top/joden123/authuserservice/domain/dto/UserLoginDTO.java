/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.domain.dto;

import top.joden123.authuserservice.domain.entity.JWT;
import top.joden123.authuserservice.domain.entity.User;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
public class UserLoginDTO {

    private JWT jwt;

    private User user;

    public JWT getJwt() {
        return jwt;
    }

    public void setJwt(JWT jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
