package com.zoucai.zucai.service;

import com.zoucai.zucai.mapper.BookMapper;
import com.zoucai.zucai.mapper.EventMapper;
import com.zoucai.zucai.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "eventService")
public class EventService {
    @Autowired
    private EventMapper eventMapper;//这里会报错，但是并不会影响

    public void insertData(Event event){
        eventMapper.insert(event);
    }
}
