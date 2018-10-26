package com.zoucai.zucai.model;

public class BookWithBLOBs extends Book {
    private String content;

    private String htmlcontent;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHtmlcontent() {
        return htmlcontent;
    }

    public void setHtmlcontent(String htmlcontent) {
        this.htmlcontent = htmlcontent == null ? null : htmlcontent.trim();
    }

    @Override
    public String toString() {
        return "BookWithBLOBs{" +
                "content='" + content + '\'' +
                ", htmlcontent='" + htmlcontent + '\'' +
                '}';
    }
}