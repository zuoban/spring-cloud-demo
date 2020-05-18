package cn.leftsite.springcloud;

import cn.leftsite.springcloud.feign.ProducerFeignClient;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringCloudApplication
@EnableFeignClients
public class ConsumerApplication {
    @Autowired
    private ProducerFeignClient producerFeignClient;

    @GetMapping
    @SentinelResource(value = "home", blockHandler = "homeBlockHandler", fallback = "homeFallback")
    public String home() {
        return producerFeignClient.home();
    }

    @GetMapping("timeout")
    @SentinelResource(value = "home", blockHandler = "homeBlockHandler", fallback = "homeFallback")
    public String timeout() {
        return producerFeignClient.timeout();
    }


    public String homeBlockHandler(BlockException e) {
        return "homeBlockHandler" + e.getMessage();
    }

    public String homeFallback(Throwable t) {
        return "homeFallback" + t.getMessage();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
