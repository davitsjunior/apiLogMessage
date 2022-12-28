package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.Scheduled.LoggedMessageTerminal;

public interface LogMessageExecutor {

    void execute (final LoggedMessageTerminal loggedMessageTerminal);
}
