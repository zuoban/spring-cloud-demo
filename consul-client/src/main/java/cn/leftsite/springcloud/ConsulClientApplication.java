package cn.leftsite.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsulClientApplication {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public String home() {
        return "consul client, " + serverPort;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }
}
