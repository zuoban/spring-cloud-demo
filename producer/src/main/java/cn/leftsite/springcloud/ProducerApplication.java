package cn.leftsite.springcloud;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProducerApplication {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public String home() {
        return "hello world!" + serverPort;
    }

    @SneakyThrows
    @GetMapping("/timeout")
    public String timeout() {
        Thread.sleep(2000);
        return "producer!" + serverPort;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
