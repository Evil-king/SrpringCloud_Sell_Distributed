package com.hwq.order.server.message;

import com.hwq.order.server.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    public void process(Object message) {
        log.info("StreamReceiver:{}", message);
    }

    /**
     * 接受对象
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    public void process(OrderDTO message) {
        log.info("StreamReceiver:{}", message);
    }
}
