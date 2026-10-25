package com.spring.ai.demoproject.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
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
    public List<tut> chat(String query){
        String prompt="tell me about viratkohli";
        //call the llm for response
        //instead of write content() we write chatresponse().getresult().getoutput().getext()
       //return openaichatclient.prompt().user(prompt).system("As expert in cricket").call().content();
       //return openaichatclient.prompt().user(query).call().content();
      // return openaichatclient.prompt(query).call().entity(tut.class);
      return openaichatclient.prompt(query).call().entity(new ParameterizedTypeReference<List<tut>>() {
        
      });
    }
    
}
