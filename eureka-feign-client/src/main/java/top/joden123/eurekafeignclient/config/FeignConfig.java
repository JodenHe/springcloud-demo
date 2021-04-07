/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.eurekafeignclient.config;

import feign.Retryer;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * feign config
 * <p>
 * Created by xiaofeng.he on 2021/04/07
 *
 * @author xiaofeng.he
 */
@Configuration
public class FeignConfig {

    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }

}
