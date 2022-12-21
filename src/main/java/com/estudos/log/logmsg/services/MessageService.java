package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.domain.entity.Messages;

import java.util.List;

public interface MessageService {

    List<Messages> getMessages();

    Messages save(Messages messages);
}
