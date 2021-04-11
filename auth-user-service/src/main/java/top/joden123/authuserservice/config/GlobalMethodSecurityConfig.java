/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class GlobalMethodSecurityConfig {
}
