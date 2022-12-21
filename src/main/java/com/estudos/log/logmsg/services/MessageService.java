package com.estudos.log.logmsg.services;

import com.estudos.log.logmsg.domain.entity.Messages;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    Optional<List<Messages>> getMessages() throws Exception;

    Messages save(Messages messages);
}
