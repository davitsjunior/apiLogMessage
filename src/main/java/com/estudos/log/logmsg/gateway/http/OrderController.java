package com.estudos.log.logmsg.gateway.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.log.logmsg.services.MsgOrderProducerService;

@RestController
@RequestMapping(value = "/msgs/")
public class OrderController {

    private final MsgOrderProducerService msgOrderProducerService;

    public OrderController (MsgOrderProducerService msgOrderProducerService){
        this.msgOrderProducerService = msgOrderProducerService;
    }

    @PostMapping()
    public void send(@RequestParam("msg") String msg){
        msgOrderProducerService.send(msg);
    }

}
