package com.example.kafkademo.service;

import com.example.kafkademo.request.ParentCommentRequest;

public interface KafkaService {
    void postParentComment(ParentCommentRequest parentComentRequest);
}
