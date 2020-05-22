package cn.leftsite.springcloud.service;

import cn.leftsite.springcloud.channel.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(OrderProcessor.class)
public class MessageSender {
    @Autowired
    private MessageChannel outputOrder;


    public void sendOrder(Object message) {
        outputOrder.send(MessageBuilder.withPayload(message).build());
    }
}
