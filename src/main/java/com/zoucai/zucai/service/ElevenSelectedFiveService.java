package com.zoucai.zucai.service;

import com.zoucai.zucai.mapper.ElevenSelectedFiveMapper;
import com.zoucai.zucai.mapper.EventMapper;
import com.zoucai.zucai.model.ElevenSelectedFive;
import com.zoucai.zucai.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "elevenSelectedFiveService")
public class ElevenSelectedFiveService {
    @Autowired
    private ElevenSelectedFiveMapper elevenSelectedFiveMapper;//这里会报错，但是并不会影响

    public void insertData(ElevenSelectedFive elevenSelectedFive){
        elevenSelectedFiveMapper.insert(elevenSelectedFive);
    }
}
