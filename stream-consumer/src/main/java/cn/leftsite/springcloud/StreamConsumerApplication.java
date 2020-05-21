package cn.leftsite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamConsumerApplication {
    // 监听 binding 中的消息
    @StreamListener(Sink.INPUT)
    public void input(String message) {
        System.err.println("获取到消息： " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class);
    }
}
