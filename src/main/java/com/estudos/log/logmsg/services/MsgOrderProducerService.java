package com.estudos.log.logmsg.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MsgOrderProducerService {
    
    @Value("${order.topic}")
    private String orderTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MsgOrderProducerService(final KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send (final @PathVariable String order){
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(orderTopic,mensageKey, order);        
    }
}
