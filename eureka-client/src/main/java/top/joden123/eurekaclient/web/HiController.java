/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekaclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/06
 *
 * @author xiaofeng.he
 */
@RestController
public class HiController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ", i am from port: " + port;
    }
}
