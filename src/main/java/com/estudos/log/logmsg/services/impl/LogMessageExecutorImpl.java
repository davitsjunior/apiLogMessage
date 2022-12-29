package com.estudos.log.logmsg.services.impl;

import com.estudos.log.logmsg.Threads.LoggedMessageTerminal;
import com.estudos.log.logmsg.services.LogMessageExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class LogMessageExecutorImpl implements LogMessageExecutor {

    public void execute(LoggedMessageTerminal loggedMessageTerminal) throws Exception {
        loggedMessageTerminal.logMessage();
    }
}
