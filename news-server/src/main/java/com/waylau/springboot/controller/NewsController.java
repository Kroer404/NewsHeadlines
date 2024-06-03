package com.waylau.springboot.controller;

import com.waylau.springboot.newsserver.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/news")
@RestController
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    public List<News> getNewsList() {
        Iterable<News> newsIterable = newsRepository.findAll();
        List<News> newsList = new ArrayList<>();

        newsIterable.forEach(news ->{
            newsList.add(news);

        });


        return newsList;
    }

}
