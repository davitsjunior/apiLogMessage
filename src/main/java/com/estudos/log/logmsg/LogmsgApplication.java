package com.estudos.log.logmsg;

import com.estudos.log.logmsg.Threads.LoggedMessageTerminal;
import com.estudos.log.logmsg.domain.entity.Messages;
import com.estudos.log.logmsg.domain.repository.MessagesRepository;
import com.estudos.log.logmsg.services.LogMessageExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class LogmsgApplication {

	@Bean
	public CommandLineRunner commandLineRunner (@Autowired MessagesRepository messagesRepository,
												@Autowired LogMessageExecutor logMessageExecutor, @Autowired LoggedMessageTerminal log){
		return  args -> {
			for (int i = 0; i < 100; i++) {
				Messages messages = new Messages();
				messages.setMessage("Mensagem teste " + i);
				messages.setTimeAt(new Date().getTime());
				messages.setMessageKey(UUID.randomUUID().toString());
				messagesRepository.save(messages);
				//Thread.sleep(1000);
			}
			logMessageExecutor.execute(log);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(LogmsgApplication.class, args);
	}
}
//update messages m set m.message_logged wher m.id =1