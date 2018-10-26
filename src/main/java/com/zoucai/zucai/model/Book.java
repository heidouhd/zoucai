package com.zoucai.zucai.model;

import java.util.Date;

public class Book {
    private Long id;

    private String title;

    private Date dtcreattime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getDtcreattime() {
        return dtcreattime;
    }

    public void setDtcreattime(Date dtcreattime) {
        this.dtcreattime = dtcreattime;
    }
}