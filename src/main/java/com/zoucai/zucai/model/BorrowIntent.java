package com.zoucai.zucai.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tbBorrowIntent")
@Data
public class BorrowIntent {
    @Id
    private String _id;

    private Long lBorrowIntentId;

    private Long lBorrowerId;

    private String strBorrowerName;

}