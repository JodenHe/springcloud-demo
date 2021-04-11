/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.feign.fallback;

import org.springframework.stereotype.Component;
import top.joden123.authuserservice.domain.entity.JWT;
import top.joden123.authuserservice.feign.AuthServiceFeign;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
@Component
public class AuthServiceFeignFallback implements AuthServiceFeign {

    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
