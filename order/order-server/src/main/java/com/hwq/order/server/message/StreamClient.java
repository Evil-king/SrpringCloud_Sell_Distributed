package com.hwq.order.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String INPUT = "myMessage";

    @Input(StreamClient.INPUT)
    default SubscribableChannel input() {
        return null;
    }

    @Output(StreamClient.INPUT)
    MessageChannel output();


}
