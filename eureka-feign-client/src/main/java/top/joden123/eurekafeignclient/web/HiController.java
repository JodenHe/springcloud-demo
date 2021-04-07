/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekafeignclient.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.joden123.eurekafeignclient.service.HiService;

/**
 * hi controller
 * <p>
 * Created by xiaofeng.he on 2021/04/07
 *
 * @author xiaofeng.he
 */
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "SINDY", required = false) String name) {
        return hiService.sayHi(name);
    }

}
