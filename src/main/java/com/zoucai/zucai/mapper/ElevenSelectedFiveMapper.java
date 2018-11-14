package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.ElevenSelectedFive;

public interface ElevenSelectedFiveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ElevenSelectedFive record);

    int insertSelective(ElevenSelectedFive record);

    ElevenSelectedFive selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ElevenSelectedFive record);

    int updateByPrimaryKey(ElevenSelectedFive record);
}