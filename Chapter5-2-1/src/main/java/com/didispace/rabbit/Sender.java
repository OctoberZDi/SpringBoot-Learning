package com.didispace.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    RabbitTemplate rabbitTemp;

    public void send() {
        String context = "hello " + new Date();
        System.err.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    public void send2() {
        String context = "hello222 " + new Date();
        System.err.println("Sender22 : " + context);
        this.rabbitTemp.convertAndSend("hello2", context);
    }
}