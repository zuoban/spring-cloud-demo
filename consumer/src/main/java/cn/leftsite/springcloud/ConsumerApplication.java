package cn.leftsite.springcloud;

import cn.leftsite.springcloud.feign.ProducerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableFeignClients
public class ConsumerApplication {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @GetMapping
    public String home() {
        return producerFeignClient.home();
    }

    @GetMapping("timeout")
    public String timeout() {
        return producerFeignClient.timeout();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
