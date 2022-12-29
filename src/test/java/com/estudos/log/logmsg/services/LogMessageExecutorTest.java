package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.Threads.LoggedMessageTerminal;
import com.estudos.log.logmsg.domain.entity.Messages;
import com.estudos.log.logmsg.services.impl.LogMessageParallel;
import com.estudos.log.logmsg.services.impl.LogMessageSeq;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class LogMessageExecutorTest {

    @Test
    void testSequencial(){
        System.out.println("-----------------------------------");
        System.out.println("Executando Rotina Sequencial");
        System.out.println("-----------------------------------");
        LogMessageExecutor executor = new LogMessageSeq();
        for (LoggedMessageTerminal log : getList()){
            executor.execute(log);
        }
    }

    @Test
    void testParalelo(){
        System.out.println("-----------------------------------");
        System.out.println("Executando Rotinha Paralela");
        System.out.println("-----------------------------------");
        LogMessageExecutor executor = new LogMessageParallel();
        for (LoggedMessageTerminal log : getList()){
            executor.execute(log);
        }
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private List<LoggedMessageTerminal> getList(){
        List<LoggedMessageTerminal> log = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Messages message = new Messages();
            message.setId(i);
            message.setMessage("Mensagem teste " + i);
            message.setTimeAt(new Date().getTime());
            message.setMessageKey(UUID.randomUUID().toString());
            log.add(new LoggedMessageTerminal(message));
        }
        return log;
    }
}