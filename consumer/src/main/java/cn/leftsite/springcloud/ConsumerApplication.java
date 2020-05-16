package cn.leftsite.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringCloudApplication
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerApplication {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping
    @HystrixCommand(fallbackMethod = "homeFallback")
    public String home() {
        return restTemplate.getForObject("http://producer", String.class);
    }

    @GetMapping("/default")
    @HystrixCommand
    public String defaultF() {
        return restTemplate.getForObject("http://producer/xx", String.class);
    }

    @GetMapping("/timeout")
    @HystrixCommand
    public String timeout() {
        return restTemplate.getForObject("http://producer/timeout", String.class);
    }

    public String homeFallback() {
        return "fallback method";
    }

    public String defaultFallback() {
        return "default Fallback";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
