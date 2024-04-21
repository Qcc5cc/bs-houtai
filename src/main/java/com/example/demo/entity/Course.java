package com.example.demo.entity;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String course_name;
    private Integer teacher_id;
    private String teacher;
    private String school;
    private String introduction;
    private byte[] imageUrl;
}
