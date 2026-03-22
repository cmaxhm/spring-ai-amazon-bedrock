package com.involvedstudio.amazonbedrockrag.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {
  private final ChatClient chatClient;

  @Autowired
  public AiController(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @GetMapping
  public String generate(@RequestParam String prompt) {
    String conversationId = "001"; // TODO: For testing purposes, generate dynamically in frontend and store in backend

    return chatClient.prompt()
      .user(prompt)
      .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
      .call()
      .content();
  }
}
