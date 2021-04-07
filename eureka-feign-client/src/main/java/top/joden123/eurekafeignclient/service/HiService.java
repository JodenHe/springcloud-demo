/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekafeignclient.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.joden123.eurekafeignclient.feign.EurekaClientFeign;

/**
 * hi service
 * <p>
 * Created by xiaofeng.he on 2021/04/07
 *
 * @author xiaofeng.he
 */
@Service
public class HiService {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

//    @CircuitBreaker(name = "hiError", fallbackMethod = "hiError")
    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }

//    public String hiError(String name, Throwable throwable) {
//        throwable.printStackTrace();
//        return "hi " + name + ", sorry, error";
//    }
}
