package com.example.demo.dao;

import com.example.demo.entity.Chapter;
import com.example.demo.entity.Course;
import com.example.demo.model.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterDAO {
    List<Chapter> getCoursesByCourseId(Integer course_id);
    Chapter getById(Integer id);
    int add(Chapter chapter);
    int delete(Integer id);
    int update(Chapter chapter);
}
