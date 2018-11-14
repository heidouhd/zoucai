package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.SuperLotto;

public interface SuperLottoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SuperLotto record);

    int insertSelective(SuperLotto record);

    SuperLotto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SuperLotto record);

    int updateByPrimaryKey(SuperLotto record);
}