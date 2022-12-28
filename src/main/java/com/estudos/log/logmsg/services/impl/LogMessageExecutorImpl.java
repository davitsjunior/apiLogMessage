package com.estudos.log.logmsg.services.impl;

import com.estudos.log.logmsg.Threads.LoggedMessageTerminal;
import com.estudos.log.logmsg.services.LogMessageExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class LogMessageExecutorImpl implements LogMessageExecutor {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);
    @Override
    public void execute(LoggedMessageTerminal loggedMessageTerminal) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    loggedMessageTerminal.logMessage();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
