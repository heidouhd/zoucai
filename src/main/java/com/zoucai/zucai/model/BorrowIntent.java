package com.zoucai.zucai.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="tbBorrowIntent")
public class BorrowIntent {
    @Id
    private Long lBorrowIntentId;

    private Long lBorrowerId;

    private String strBorrowerName;



    public Long getlBorrowIntentId() {
        return lBorrowIntentId;
    }

    public void setlBorrowIntentId(Long lBorrowIntentId) {
        this.lBorrowIntentId = lBorrowIntentId;
    }

    public Long getlBorrowerId() {
        return lBorrowerId;
    }

    public void setlBorrowerId(Long lBorrowerId) {
        this.lBorrowerId = lBorrowerId;
    }

    public String getStrBorrowerName() {
        return strBorrowerName;
    }

    public void setStrBorrowerName(String strBorrowerName) {
        this.strBorrowerName = strBorrowerName == null ? null : strBorrowerName.trim();
    }

    @Override
    public String toString() {
        return "BorrowIntent{" +
                "lBorrowIntentId=" + lBorrowIntentId +
                ", lBorrowerId=" + lBorrowerId +
                ", strBorrowerName='" + strBorrowerName + '\'' +
                '}';
    }
}