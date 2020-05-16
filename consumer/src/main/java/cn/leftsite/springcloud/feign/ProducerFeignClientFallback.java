package cn.leftsite.springcloud.feign;

import org.springframework.stereotype.Component;

@Component
public class ProducerFeignClientFallback implements ProducerFeignClient {
    @Override
    public String home() {
        return "feign hystrix fallback";
    }
}
