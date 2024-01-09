package com.microservicedemo.twittertokafkaservice;

import com.microservicedemo.twittertokafkaservice.config.TwitterToKafkaServiceConfigData;
import com.microservicedemo.twittertokafkaservice.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.microservicedemo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {
	private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;

	private final StreamRunner streamRunner;

	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("App starts...");
		log.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[] {})));
		log.info(twitterToKafkaServiceConfigData.getWelcomeMessage());
		streamRunner.start();
	}
}
