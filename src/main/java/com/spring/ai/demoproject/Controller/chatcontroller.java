package com.spring.ai.demoproject.Controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping
public class chatcontroller {
    private ChatClient chatClient;
    chatcontroller(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }
    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value="q",required=true) String query) {
        String result=chatClient.prompt(query).call().content();
        return ResponseEntity.ok(result);
    }
}
