package com.estudos.log.logmsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class LogmsgApplication {

//	@Bean
//	public CommandLineRunner commandLineRunner (@Autowired MessagesRepository messagesRepository,
//												@Autowired LogMessageExecutor logMessageExecutor, @Autowired LoggedMessageTerminal log){
//		return  args -> {
//			for (int i = 0; i < 100; i++) {
//				Messages messages = new Messages();
//				messages.setMessage("Mensagem teste " + i);
//				messages.setTimeAt(new Date().getTime());
//				messages.setMessageKey(UUID.randomUUID().toString());
//				messagesRepository.save(messages);
//				//Thread.sleep(1000);
//			}
//			logMessageExecutor.execute(log);
//		};
//	}
	public static void main(String[] args) {
		SpringApplication.run(LogmsgApplication.class, args);
	}
}
//update messages m set m.message_logged wher m.id =1