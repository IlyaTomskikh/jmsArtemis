package com.example.jmsartemis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class DispatcherService {
    final
    JmsTemplate jmsTemplate;

    @Value(value = "${jms.queue}")
    String jmsQueue;

    public DispatcherService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {
        try {
            jmsTemplate.convertAndSend(jmsQueue, message);
        } catch (Exception e) {
            System.out.println("Disconnected on send()");
        }
    }
}
