package com.example.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafkaStreams
public class KafkaConfig {

    @Bean
    public NewTopic commentTopic() {
        return TopicBuilder.name("comments")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic outputTopic(){
        return TopicBuilder.name("output")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
