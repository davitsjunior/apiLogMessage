package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.Scheduled.LoggedMessageSequencial;
import com.estudos.log.logmsg.domain.entity.Messages;
import com.estudos.log.logmsg.domain.repository.MessagesRepository;
import com.estudos.log.logmsg.services.impl.LogMessageExecutorImpl;
import com.estudos.log.logmsg.services.impl.MessageServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.logging.Logger;

@ExtendWith(MockitoExtension.class)
class LogMessageExecutorTest {

    private final Logger logger = Logger.getLogger(String.valueOf(LogMessageExecutorTest.class));
    //static Messages message = new Messages();
    static  List<Messages> messages = new ArrayList<>();

    @Mock
    MessagesRepository messagesRepository;

    @Mock
    MessageServiceImpl messageService;

    @BeforeAll
    public static void setup() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Messages message = new Messages();
            message.setId(i);
            message.setMessage("Mensagem teste " + i);
            message.setTimeAt(new Date().getTime());
            message.setMessageKey(UUID.randomUUID().toString());
            messages.add(message);
            Thread.sleep(1000);
        }
    }

    @Test
    void testSequencial() throws Exception {

        LoggedMessageSequencial loggedMessageSequencial = new LoggedMessageSequencial(messageService);
        Mockito.when(messageService.getMessages()).thenReturn(Optional.ofNullable(messages));
        LogMessageExecutor logMessageExecutor = new LogMessageExecutorImpl();
        logMessageExecutor.execute(loggedMessageSequencial);

    }
}