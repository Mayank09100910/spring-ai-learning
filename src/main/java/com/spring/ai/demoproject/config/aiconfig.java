package com.spring.ai.demoproject.config;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration 
public class aiconfig {
    @Bean(name="openAiChatClient")
    public ChatClient openaichatmodel(OpenAiChatModel chatModel){
 
    return ChatClient.builder(chatModel).build();

    }

@Bean(name="ollamaChatClient")
public ChatClient ollamChatClient(OllamaChatModel chatmodel){
    return ChatClient.builder(chatmodel).build();
}

}
