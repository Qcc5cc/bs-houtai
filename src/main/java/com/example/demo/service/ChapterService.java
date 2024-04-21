package com.example.demo.service;

import com.example.demo.entity.Chapter;
import com.example.demo.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {
    Result<List<Chapter>> getChaptersByCourseId(Integer course_id);

    Result<Chapter> add(Chapter chapter);
    Result<Chapter> delete(Integer id);
    Result<Chapter> getById(Integer id);
    Result<Chapter> update(Chapter chapter);
}
