package com.example.jmsartemis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;


@Service
public class ReceiverService {
    Logger logger = LoggerFactory.getLogger(ReceiverService.class);

    @JmsListener(destination = "${jms.queue}")
    public void receiveMessage(String message) {
        try {
            logger.info("\nThread ID = " + Thread.currentThread().getId() +
                    "\nReceived: " + message +
                    "\nFree memory in heap: " + Runtime.getRuntime().freeMemory() + " bytes." +
                    "\n________________________________________________________________________\n");
        } catch (Exception e) {
            logger.info("Disconnected on receive()");
        }
    }
}
