package com.estudos.log.logmsg.services.impl;

import com.estudos.log.logmsg.Threads.LoggedMessageTerminal;
import com.estudos.log.logmsg.services.LogMessageExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class LogMessageParallel implements LogMessageExecutor {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    @Override
    public void execute(LoggedMessageTerminal loggedMessageTerminal) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                loggedMessageTerminal.logMessage();
            }
        });
    }
}
