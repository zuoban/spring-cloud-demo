package cn.leftsite.springcloud.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageSenderTest {
    @Autowired
    MessageSender messageSender;

    @Test
    public void send() {
        for (int i = 0; i < 3; i++) {
            IntStream.range(0, 5).forEach(it -> {
                messageSender.send("hello ~~~ " + it);
            });
        }
    }
}
