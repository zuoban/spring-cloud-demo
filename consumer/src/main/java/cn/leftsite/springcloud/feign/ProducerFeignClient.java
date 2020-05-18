package cn.leftsite.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer", fallback = ProducerFeignFallback.class)
public interface ProducerFeignClient {
    @GetMapping("/")
    String home();

    @GetMapping("/timeout")
    String timeout();
}
