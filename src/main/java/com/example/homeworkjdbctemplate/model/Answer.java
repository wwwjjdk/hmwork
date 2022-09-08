package com.example.homeworkjdbctemplate.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class Answer {
    String name;
    String productName;
    int price;
}
