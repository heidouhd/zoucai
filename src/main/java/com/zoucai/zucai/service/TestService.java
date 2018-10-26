package com.zoucai.zucai.service;

import com.zoucai.zucai.mapper.BookMapper;
import com.zoucai.zucai.model.BookWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "testService")
public class TestService {
    @Autowired
    private BookMapper bookMapper;//这里会报错，但是并不会影响

    public BookWithBLOBs getBook(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

}
