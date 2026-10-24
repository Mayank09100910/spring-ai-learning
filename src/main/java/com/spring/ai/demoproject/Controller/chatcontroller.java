package com.spring.ai.demoproject.Controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.ai.demoproject.config.aiconfig;
import com.openai.models.ChatModel;
@RestController
@RequestMapping
public class chatcontroller {
    private ChatClient ollamachatclient;
    private ChatClient openaichatclient;
    public chatcontroller(@Qualifier("openAiChatClient")ChatClient openAiChatClient, @Qualifier ("ollamaChatClient")ChatClient ollamChatClient){
        this.ollamachatclient=ollamChatClient;
        this.openaichatclient=openAiChatClient;
    }
    // chatcontroller(OpenAiChatModel openaichatmodel, OllamaChatModel ollamachatmodel) {
    //     this.openaichatclient = ChatClient.builder(openaichatmodel).build();
    //     this.ollamachatclient=ChatClient.builder(ollamachatmodel).build();
    // }
    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="q",required=true) String query) {
        String result=openaichatclient.prompt(query).call().content();
        return ResponseEntity.ok(result);
    }
}
