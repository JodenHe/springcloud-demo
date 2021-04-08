package top.joden123.eurekagatewayclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaGatewayClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayClientApplication.class, args);
    }

}
