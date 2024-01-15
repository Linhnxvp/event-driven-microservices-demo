package com.example.kafkademo.service.impl;

import com.example.kafkademo.entity.ParentComment;
import com.example.kafkademo.request.ParentCommentRequest;
import com.example.kafkademo.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String, ParentComment> kafkaTemplate;

    @Override
    public void postParentComment(ParentCommentRequest parentComentRequest) {
        ParentComment parentComment = ParentComment.builder()
                .id(parentComentRequest.getId())
                .content(parentComentRequest.getContent())
                .build();
        kafkaTemplate.send("comments", parentComment);
    }

    @KafkaListener(topics = "comments", groupId = "comment-consumer")
    public void listen(@Payload ParentComment parentCommentRequest) {
        System.out.println("Received Message in group foo: " + parentCommentRequest);
    }

}
