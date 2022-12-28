package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.Scheduled.LoggedMessageSequencial;

public interface LogMessageExecutor {

    void execute (final LoggedMessageSequencial loggedMessageSequencial);
}
