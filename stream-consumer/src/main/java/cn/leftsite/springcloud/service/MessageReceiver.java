package cn.leftsite.springcloud.service;

import cn.leftsite.springcloud.channel.OrderProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class, OrderProcessor.class})
public class MessageReceiver {
    @StreamListener(Sink.INPUT)
    public void input(Object obj) {
        System.out.println(obj);
    }

    @StreamListener(OrderProcessor.INPUT_ORDER)
    public void inputOrder(Object obj) {
        System.out.println(obj);
    }
}
