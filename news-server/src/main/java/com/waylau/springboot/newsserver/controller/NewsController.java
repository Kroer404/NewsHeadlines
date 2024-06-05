package com.waylau.springboot.newsserver.controller;

import com.waylau.springboot.newsserver.domain.News;
import com.waylau.springboot.newsserver.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/news")
@RestController
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    public List<News> getNewsList() {
        //使用CrudRepository的findAll方法，查询所有新闻的所有信息
        Iterable<News> newsIterable = newsRepository.findAll();
        List<News> newsList = new ArrayList<>();
        newsIterable.forEach(news ->{
            newsList.add(news);
        });
        return newsList;
    }

    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable Long newsId) {
        //使用CrudRepository的findById方法，根据id查询新闻
        Optional<News> newsOptional = newsRepository.findById(newsId);
        return newsOptional.orElse(null);
    }

}
