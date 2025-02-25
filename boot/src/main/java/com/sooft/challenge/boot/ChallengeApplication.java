package com.sooft.challenge.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.sooft.challenge.infrastructure.repository.mongo"})
@SpringBootApplication(scanBasePackages = "com.sooft.challenge.*")
public class ChallengeApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChallengeApplication.class, args);
  }
}
