package com.estudos.log.logmsg.gateway.http;

import com.estudos.log.logmsg.domain.entity.Messages;
import com.estudos.log.logmsg.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final MessageService messageService;
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    public LogController (MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    public List<Messages> getMessagesLog(){
        List<Messages> messages = messageService.getMessages();
        messages.forEach(c -> c.setLoggedMessage(true));
        messages.forEach(c -> messageService.save(c));
        return messages;
    }
}
