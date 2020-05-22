package cn.leftsite.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class MessageSender {
    @Autowired
    private MessageChannel output;

    public void send(Object message) {
        output.send(MessageBuilder.withPayload(message).build());
    }
}
