package com.chc.model.mongoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

  @Bean
  public CascadeSaveMongoEventListener userCascadingMongoEventListener() {
    return new CascadeSaveMongoEventListener();
  }
}
