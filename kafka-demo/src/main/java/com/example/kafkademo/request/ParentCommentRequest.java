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
public class ParentCommentRequest implements Serializable{
    @JsonProperty("id")
    private String id;
    @JsonProperty("content")
    private String content;
}
