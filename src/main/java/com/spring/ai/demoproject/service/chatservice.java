package com.spring.ai.demoproject.service;

import java.util.List;

import com.spring.ai.demoproject.entity.tut;

public interface chatservice {
    List<tut> chat(String query);
}
