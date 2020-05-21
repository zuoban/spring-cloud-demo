package cn.leftsite.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class StreamProducerApplication implements CommandLineRunner {
    @Autowired
    private MessageChannel output;

    @Override
    public void run(String... args) throws Exception {
        output.send(MessageBuilder.withPayload("hello world").build());
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class);
    }

}
