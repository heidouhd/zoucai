package com.zoucai.zucai.dao;

import com.zoucai.zucai.model.BorrowIntent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  BorrowIntenetInfoRepository extends MongoRepository<BorrowIntent,Long> {

     BorrowIntent getByLBorrowIntentId(long lBorrowIntentId);
}
