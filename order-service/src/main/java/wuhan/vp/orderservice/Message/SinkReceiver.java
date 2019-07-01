package wuhan.vp.orderservice.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableBinding(Sink.class)
@Component
public class SinkReceiver {


    @StreamListener(Sink.INPUT)
    public void reveive(Object payload){
        log.info("接收到消息："+payload);
    }



}
