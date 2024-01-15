package com.example.kafkademo.controller;

import com.example.kafkademo.request.ParentCommentRequest;
import com.example.kafkademo.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;

    @PostMapping("/parent-comment")
    public void postParentComment(@RequestBody ParentCommentRequest request) {
        kafkaService.postParentComment(request);
    }
}
