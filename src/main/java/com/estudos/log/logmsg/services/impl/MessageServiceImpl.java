package com.estudos.log.logmsg.services.impl;

import com.estudos.log.logmsg.domain.entity.Messages;
import com.estudos.log.logmsg.domain.repository.MessagesRepository;
import com.estudos.log.logmsg.services.MessageService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessagesRepository messagesRepository;

    public MessageServiceImpl (MessagesRepository messagesRepository){
        this.messagesRepository = messagesRepository;
    }

    @Override
    public Optional<List<Messages>> getMessages() throws Exception {
        Optional<List<Messages>> messages;
        return Optional.ofNullable(messagesRepository.findAllMessagesNotLog().orElseThrow(() -> new Exception("Erro na busca dos dados")));
    }

    @Override
    public Messages save(Messages messages) {
        messagesRepository.save(messages);
        return messages;
    }
}
