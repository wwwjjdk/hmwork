package com.example.homeworkjdbctemplate.repository;

import com.example.homeworkjdbctemplate.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {
    private static final String LINE = "myScript.sql";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<Answer> search(String name) {

        return namedParameterJdbcTemplate.query(read(LINE),
               Map.of("nameOf", name),
                 (rs, rowNum) -> new Answer(rs.getString("nameOf"),
                         rs.getString("product_name"),rs.getInt("price")));
    }


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
