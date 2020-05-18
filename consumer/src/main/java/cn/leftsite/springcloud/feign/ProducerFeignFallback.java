package cn.leftsite.springcloud.feign;

import org.springframework.stereotype.Component;

@Component
public class ProducerFeignFallback implements ProducerFeignClient{

    @Override
    public String home() {
        return "home feign fallback";
    }

    @Override
    public String timeout() {
        return "timeout feign fallback";
    }
}
