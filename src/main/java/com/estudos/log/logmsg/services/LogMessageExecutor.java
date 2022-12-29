package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.Threads.LoggedMessageTerminal;

public interface LogMessageExecutor {

    void execute (final LoggedMessageTerminal loggedMessageTerminal);
}
