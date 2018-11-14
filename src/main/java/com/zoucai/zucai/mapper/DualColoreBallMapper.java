package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.DualColoreBall;

public interface DualColoreBallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DualColoreBall record);

    int insertSelective(DualColoreBall record);

    DualColoreBall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DualColoreBall record);

    int updateByPrimaryKey(DualColoreBall record);
}