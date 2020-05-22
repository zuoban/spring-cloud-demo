package cn.leftsite.springcloud.channel;

import cn.leftsite.springcloud.service.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderProcessorTest {
    @Autowired
    private MessageSender messageSender;

    @Test
    public void testOutputOrder() {
        messageSender.sendOrder("hello world. ");
    }
}
