package cn.leftsite.springcloud;

import cn.leftsite.springcloud.feign.ProducerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringCloudApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableTurbine
public class ConsumerApplication {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @GetMapping
    public String home() {
        return producerFeignClient.home();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
