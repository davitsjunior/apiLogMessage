package com.estudos.log.logmsg.domain.repository;

import com.estudos.log.logmsg.domain.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    @Query(
            value = "select * from messages m where m.logged_message = FALSE",
            nativeQuery = true)
     Optional<List<Messages>> findAllMessagesNotLog();
}
