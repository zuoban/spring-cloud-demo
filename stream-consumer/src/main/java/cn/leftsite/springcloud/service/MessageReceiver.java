package cn.leftsite.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class MessageReceiver {
    @StreamListener(Sink.INPUT)
    public void input(Object obj) {
        System.out.println(obj);
    }
}
