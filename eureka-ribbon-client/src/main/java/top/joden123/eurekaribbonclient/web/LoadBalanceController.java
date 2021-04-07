/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekaribbonclient.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.joden123.eurekaribbonclient.service.LoadBalanceService;

/**
 * 负载均衡controller
 * <p>
 * Created by xiaofeng.he on 2021/04/07
 *
 * @author xiaofeng.he
 */
@RestController
public class LoadBalanceController {

    @Autowired
    private LoadBalanceService loadBalanceService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false, defaultValue = "SINDY") String name) {
        return loadBalanceService.hi(name);
    }

    @GetMapping("/test-ribbon")
    public String testRibbon() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        return instance.getHost() + ":" + instance.getPort();
    }
}
