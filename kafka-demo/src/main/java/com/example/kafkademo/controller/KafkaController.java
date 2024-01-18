package com.example.kafkademo.controller;

import com.example.kafkademo.request.CommentRequest;
import com.example.kafkademo.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;

    @PostMapping("/parent-comment")
    public void postParentComment(@RequestBody CommentRequest request) {
        kafkaService.postParentComment(request);
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
