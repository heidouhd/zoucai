package com.zoucai.zucai.service;

import com.zoucai.zucai.dao.BorrowIntenetInfoRepository;
import com.zoucai.zucai.model.BorrowIntent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BorrowIntenetInfoService {

    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private BorrowIntenetInfoRepository borrowIntenetInfoRepository;

    public BorrowIntent get(long id) {
        return borrowIntenetInfoRepository.getByLBorrowIntentId(id);
    }
}
