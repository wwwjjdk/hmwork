package com.example.homeworkjdbctemplate.service;

import com.example.homeworkjdbctemplate.model.Answer;
import com.example.homeworkjdbctemplate.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository myRepository) {
        this.repository = myRepository;
    }

    public List<Answer> search(String name){
       return repository.search(name);
    }
}
