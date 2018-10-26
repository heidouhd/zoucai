package com.zoucai.zucai.mapper;

import com.zoucai.zucai.model.Book;
import com.zoucai.zucai.model.BookWithBLOBs;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    BookWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
}