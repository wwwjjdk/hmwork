package com.example.homeworkjdbctemplate.controller;

import com.example.homeworkjdbctemplate.model.Answer;
import com.example.homeworkjdbctemplate.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }
     @GetMapping("/{name}")
    public List<Answer> search(@PathVariable String name){
         System.out.println(name);
        return service.search(name);
    }
}
