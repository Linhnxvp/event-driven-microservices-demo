package com.example.kafkademo.service;

import com.example.kafkademo.entity.ParentComment;
import com.example.kafkademo.request.ParentCommentRequest;

import java.util.List;

public interface KafkaService {
    void postParentComment(ParentCommentRequest parentComentRequest);
    List<ParentComment> getParentCommentsByPostId(String postId);
}
