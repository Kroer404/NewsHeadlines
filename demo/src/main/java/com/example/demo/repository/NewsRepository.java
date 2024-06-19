package com.example.demo.repository;

import com.example.demo.domain.News;
import org.springframework.data.repository.CrudRepository;


public interface NewsRepository extends CrudRepository<News, Long> {

}