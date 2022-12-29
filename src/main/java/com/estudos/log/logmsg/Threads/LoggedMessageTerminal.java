package com.estudos.log.logmsg.Threads;

import com.estudos.log.logmsg.domain.entity.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggedMessageTerminal {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggedMessageTerminal.class);

    private final Messages message;

    public LoggedMessageTerminal(Messages message){
        this.message = message;
    }

    public void logMessage(){

        try {
            Thread.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        LOGGER.debug(message.toString());
    }
}
