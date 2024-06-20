package com.example.demo.controller;

import com.example.demo.domain.News;
import com.example.demo.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/news")
@RestController
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    //查询新闻列表接口
    @GetMapping
    public List<News> getNewsList() {
        //使用CrudRepository的findAll方法，查询所有新闻的所有信息
        Iterable<News> newsIterable = newsRepository.findAll();
        List<News> newsList = new ArrayList<>();
        newsIterable.forEach(news -> {
            newsList.add(news);
        });
        return newsList;
    }

    //根据id查询新闻接口
    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable Long newsId) {
        //使用CrudRepository的findById方法，根据id查询新闻
        Optional<News> newsOptional = newsRepository.findById(newsId);
        return newsOptional.orElse(null);
    }

    //新增新闻接口
    @PostMapping("/add")
    public News addNews(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String creation

    ) {
        //使用CrudRepository的save方法，保存新闻
        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setCreation(creation);
         this.newsRepository.save(news);
         return null;
    }


    //更新新闻接口
    @PatchMapping("/{newsId}")
    public News updateNews(
            @PathVariable Long newsId,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String creation
    ) {
        Optional<News> n = this.newsRepository.findById(newsId);
        News News = n.orElse(null);
        if (News == null) {
            News = new News();
        }
        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setCreation(creation);
        this.newsRepository.save(News);
        return null;

    }

    //删除新闻接口
    @DeleteMapping("/{newsId}")
    public String delete(
            @PathVariable Long newsId
    ) {
        this.newsRepository.deleteById(newsId);
        return null;
    }
}