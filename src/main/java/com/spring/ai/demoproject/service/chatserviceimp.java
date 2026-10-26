package com.spring.ai.demoproject.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.spring.ai.demoproject.entity.tut;
import com.spring.ai.demoproject.service.chatservice;
@Service 
public class chatserviceimp implements chatservice{

    public ChatClient openaichatclient;
    chatserviceimp(@Qualifier("openAiChatClient")ChatClient openaichatclient){
        this.openaichatclient=openaichatclient;
    }
    @Override 
    public String chat(String query){
        String prompt="tell me about viratkohli";
        
        Prompt prompt1=new Prompt(query);
        //call the llm for response
        //instead of write content() we write chatresponse().getresult().getoutput().getext()
       //return openaichatclient.prompt().user(prompt).system("As expert in cricket").call().content();
       //return openauchatclient.prompt(q).call().chatResponse().getResult().getOutput().getText();
       return openaichatclient.prompt(prompt1).call().content();
      // return openaichatclient.prompt(query).call().entity(tut.class);
     // return openaichatclient.prompt(query).call().entity(new ParameterizedTypeReference<List<tut>>() {});
    }
    
}
