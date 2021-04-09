/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.userservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/09
 *
 * @author xiaofeng.he
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hi")
    public String hi() {
        return "I am SINDY";
    }

}
