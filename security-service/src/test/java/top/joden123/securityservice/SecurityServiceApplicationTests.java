package top.joden123.securityservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncode() {
        String sindyPassword = passwordEncoder.encode("sindy520");
        String adminPassword = passwordEncoder.encode("123456");
        System.out.println("sindy password: " + sindyPassword);
        System.out.println("admin password: " + adminPassword);
    }
}
