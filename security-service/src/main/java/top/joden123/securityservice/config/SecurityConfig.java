/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.securityservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 配置 spring security
 * <p>
 * Created by xiaofeng.he on 2021/04/10
 *
 * @author xiaofeng.he
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 以 "/css/**" 开头的资源和 "/index" 资源不需要验证，外界请求可以直接访问这些资源
                .antMatchers("/css/**", "/index").permitAll()
                // 以 "/user/**" 和 "/blogs/**" 开头的资源需要验证，并且需要用户的角色是 "USER"
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                // 表单登录的地址是 "/login", 登录失败的地址是 "/login-error"
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                // 异常处理会重定向到 "401" 界面
                .exceptionHandling().accessDeniedPage("/401")
                .and()
                // 注销登录成功，重定向到首页
                .logout().logoutSuccessUrl("/");
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("sindy")
//                .password(passwordEncoder().encode("sindy520"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder().encode("123456"))
//                .roles("ADMIN", "USER");

//        auth.userDetailsService(userDetailsService());
        auth.userDetailsService(userDetailsService);
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        // 在内存中存放用户信息
//        manager.createUser(User.withUsername("sindy").password(passwordEncoder().encode("sindy520"))
//                .roles("USER").build());
//        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("123456")).roles("ADMIN", "USER").build());
//        return manager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
