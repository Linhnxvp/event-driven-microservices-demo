package com.example.kafkademo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListenerService {
    private final SimpMessagingTemplate simpMessagingTemplate;
    @KafkaListener(topics = "output", groupId = "comment-consumer")
    public void listen(@Payload String message) {
        simpMessagingTemplate.convertAndSend("/topic/group", message);
        System.out.println();
    }
}
