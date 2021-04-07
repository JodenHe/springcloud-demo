/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekafeignclient.feign;

import org.springframework.stereotype.Component;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/08
 *
 * @author xiaofeng.he
 */
@Component
public class EurekaClientFeignFallback implements EurekaClientFeign{

    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi " + name + ", sorry, error";
    }
}
