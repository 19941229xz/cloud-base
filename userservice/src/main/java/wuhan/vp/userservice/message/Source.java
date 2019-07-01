package wuhan.vp.userservice.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {

    String OUTPUT= "output";

    @Output(OUTPUT)
    MessageChannel send();

}
