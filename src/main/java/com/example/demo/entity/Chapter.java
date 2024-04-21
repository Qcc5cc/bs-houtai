package com.example.demo.entity;

import lombok.Data;

@Data
public class Chapter {
    private Integer id;
    private String course_id;
    private String chapter_name;
    private String resourceUrl;
}
