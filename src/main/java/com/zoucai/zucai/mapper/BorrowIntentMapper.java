package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.BorrowIntent;

public interface BorrowIntentMapper {
    int deleteByPrimaryKey(Long lBorrowIntentId);

    int insert(BorrowIntent record);

    int insertSelective(BorrowIntent record);

    BorrowIntent selectByPrimaryKey(Long lBorrowIntentId);

    int updateByPrimaryKeySelective(BorrowIntent record);

    int updateByPrimaryKeyWithBLOBs(BorrowIntent record);

    int updateByPrimaryKey(BorrowIntent record);
}