package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.DualColoreBall;

import java.util.List;

public interface DualColoreBallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DualColoreBall record);

    int insertSelective(DualColoreBall record);

    DualColoreBall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DualColoreBall record);

    int updateByPrimaryKey(DualColoreBall record);

    List<DualColoreBall> queryDualColoreBallData();
}