package com.estudos.log.logmsg.Scheduled;

import com.estudos.log.logmsg.domain.entity.Messages;
import com.estudos.log.logmsg.services.MessageService;
import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledLog {

    private final MessageService messageService;
    //private static final Logger logger = LoggerFactory.getLogger(ScheduledLog.class);

    public ScheduledLog(MessageService messages){
        this.messageService = messages;
    }
    @Scheduled(fixedDelay = 10000)
    public void logMessage() throws Exception {

        messageService.getMessages().map(c ->{
            c.forEach( d -> {
                d.setLoggedMessage(true);
                messageService.save(d);
                System.out.println(d.toString());
            });
            System.out.println("------------------- FIM DO CICLO ------------------------");
            return c;
        }).orElseThrow(() -> new RuntimeException("ERRO NA EXECUÇÃO"));
    }
}
