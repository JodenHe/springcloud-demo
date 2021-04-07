/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekaribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡service
 * <p>
 * Created by xiaofeng.he on 2021/04/07
 *
 * @author xiaofeng.he
 */
@Service
public class LoadBalanceService {

    @Autowired
    private RestTemplate restTemplate;

    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
    }
}
