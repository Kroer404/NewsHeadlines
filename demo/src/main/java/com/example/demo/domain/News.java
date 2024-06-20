package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//另一个导入的是非关系型数据库，不行，只允许这个
import jakarta.persistence.Id;

import java.util.Date;

@Entity // 实体
public class News {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    private Long newsId; // 实体一个唯一标识
    private String title;
    private String content;
    private String creation;

    public News() { // 无参构造函数；设为 protected 防止直接使用
    }

    public News(String title, String content, String creation) {
        this.title = title;
        this.content = content;
        this.creation = creation;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    @Override
    public String toString() {
        return String.format("News[newsId=%d, content='%s', creation='%s']", newsId, content, creation);
    }
}