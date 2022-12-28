package com.estudos.log.logmsg.Scheduled;

import com.estudos.log.logmsg.services.MessageService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoggedMessageParallel {

    private final MessageService messageService;

    public LoggedMessageParallel(MessageService messages){
        this.messageService = messages;
    }

    public void logMessage() throws Exception {
        while (true){
            messageService.getMessages().map(c ->{
                c.forEach( d -> {
                    long now = new Date().getTime();
                    if (now - d.getTimeAt() > 5000){
                        System.out.println(d.toString());
                        d.setLoggedMessage(true);
                        messageService.save(d);
                        System.out.println(now - d.getTimeAt());
                    }
                });
                System.out.println("------------------- FIM DO CICLO ------------------------");
                return c;
           }).orElseThrow(() -> new RuntimeException("ERRO NA EXECUÇÃO"));
           Thread.sleep(2000);
       }
   }
}
