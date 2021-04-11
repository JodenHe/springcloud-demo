/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import top.joden123.authuserservice.domain.entity.JWT;
import top.joden123.authuserservice.feign.fallback.AuthServiceFeignFallback;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
@FeignClient(value = "uaa-service", fallback = AuthServiceFeignFallback.class)
public interface AuthServiceFeign {

    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);
}
