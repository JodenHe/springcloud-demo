/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekafeignclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.joden123.eurekafeignclient.config.FeignConfig;

/**
 * eureka client feign
 * <p>
 * Created by xiaofeng.he on 2021/04/07
 *
 * @author xiaofeng.he
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class, fallback = EurekaClientFeignFallback.class)
public interface EurekaClientFeign {

    @GetMapping(value = "/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
