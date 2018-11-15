package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.Event;
import com.zoucai.zucai.service.EventService;

import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

    List<EventService> queryZuCaiData();
}