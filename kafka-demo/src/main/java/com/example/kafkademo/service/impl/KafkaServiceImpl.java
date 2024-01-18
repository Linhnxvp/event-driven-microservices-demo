package com.example.kafkademo.service.impl;

import com.example.kafkademo.entity.Comment;
import com.example.kafkademo.repository.CommentRepository;
import com.example.kafkademo.request.CommentRequest;
import com.example.kafkademo.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String, Comment> kafkaTemplate;
    private final CommentRepository commentRepository;

    @Override
    public void postParentComment(CommentRequest parentComentRequest) {
        Comment parentComment = Comment.builder()
                .author(parentComentRequest.getAuthor())
                .content(parentComentRequest.getContent())
                .build();
        kafkaTemplate.send("comments", "1", parentComment);
        commentRepository.save(parentComment);
    }


}
