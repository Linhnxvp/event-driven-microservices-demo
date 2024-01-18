package com.example.kafkademo.service;

import com.example.kafkademo.request.CommentRequest;

public interface KafkaService {
    void postParentComment(CommentRequest parentComentRequest);
}
