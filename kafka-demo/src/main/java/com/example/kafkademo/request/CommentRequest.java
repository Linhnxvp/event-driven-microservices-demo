package com.example.kafkademo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest{
    @JsonProperty("author")
    private String author;
    @JsonProperty("content")
    private String content;
}
