package com.example.kafkademo.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChildComment {
    private String id;
    private String parentId;
    private String content;
}
