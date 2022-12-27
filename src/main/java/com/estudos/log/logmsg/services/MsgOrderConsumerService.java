package com.estudos.log.logmsg.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.estudos.log.logmsg.domain.entity.Messages;

@Service
public class MsgOrderConsumerService {

    private final MessageService messageService;

    public MsgOrderConsumerService(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord consumerRecord){
        Messages messages = new Messages();

        messages.setMessage(consumerRecord.value().toString());
        messages.setMessageKey(consumerRecord.key().toString());
        messages.setTimeAt(consumerRecord.timestamp());

        messageService.save(messages);

    }
}
