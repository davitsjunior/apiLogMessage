package com.estudos.log.logmsg.gateway.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.log.logmsg.services.OrderProducer;

@RestController
@RequestMapping(value = "/msgs/")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController (OrderProducer orderProducer){
        this.orderProducer = orderProducer;
    }

    @PostMapping()
    public void send(@RequestParam("msg") String msg){
        orderProducer.send(msg);
    }

}
