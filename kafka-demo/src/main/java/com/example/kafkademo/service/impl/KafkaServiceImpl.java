package com.example.kafkademo.service.impl;

import com.example.kafkademo.entity.ParentComment;
import com.example.kafkademo.request.ParentCommentRequest;
import com.example.kafkademo.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String, ParentComment> kafkaTemplate;
    private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    @Override
    public void postParentComment(ParentCommentRequest parentComentRequest) {
        ParentComment parentComment = ParentComment.builder()
                .id(parentComentRequest.getId())
                .content(parentComentRequest.getContent())
                .build();
        kafkaTemplate.send("comments", parentComment);
    }

    @Override
    public List<ParentComment> getParentCommentsByPostId(String postId) {
        return null;
    }

    @KafkaListener(topics = "comments", groupId = "comment-consumer")
    public void listen(@Payload ParentComment parentCommentRequest) {
        System.out.println("Received Message in group foo: " + parentCommentRequest);
    }

//    public List<ParentComment> getParentCommentsById(String postId) {
//        ReadOnlyKeyValueStore<String, Long> cmtData = streamsBuilderFactoryBean.getKafkaStreams()
//                .store(StoreQueryParameters.fromNameAndType(
//                        "pcomment",
//                        QueryableStoreTypes.keyValueStore()
//                ));
//
//        var cmt = cmtData.all();
//        var spliterator = Spliterators.spliteratorUnknownSize(cmt, 0);
//        return StreamSupport.stream(spliterator, false)
//                .map(data -> new ParentComment(data.key, data.value.toString()))
//                .collect(Collectors.toList());
//    }

}
