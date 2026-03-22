package com.involvedstudio.amazonbedrockrag.configuration;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ChatMemoryConfiguration {
  @Bean
  public InMemoryChatMemoryRepository inMemoryChatMemoryRepository() {
    return new InMemoryChatMemoryRepository();
  }

  @Bean
  public ChatMemory chatMemory(InMemoryChatMemoryRepository repository) {
    return MessageWindowChatMemory.builder()
      .chatMemoryRepository(repository)
      .maxMessages(10)
      .build();
  }
}
