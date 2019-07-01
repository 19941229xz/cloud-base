package wuhan.vp.userservice.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Source.class)
public class SourceSender {

    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    public void send(String msg){
        channel.send(MessageBuilder.withPayload(msg).build());
    }

}
