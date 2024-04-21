package com.example.demo.service.impl;

import com.example.demo.dao.ChapterDAO;
import com.example.demo.entity.Chapter;
import com.example.demo.model.Result;
import com.example.demo.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    @Override
    public Result<List<Chapter>> getChaptersByCourseId(Integer course_id) {
        Result<List<Chapter>> result = new Result<>();
        List<Chapter> chapters = chapterDAO.getCoursesByCourseId(course_id);
        result.setResultSuccess("获取章节成功",chapters);
        return result;
    }

    @Override
    public Result<Chapter> add(Chapter chapter) {
        Result<Chapter> result = new Result<>();
        chapterDAO.add(chapter);
        result.setResultSuccess("success",chapter);
        return result;
    }

    @Override
    public Result<Chapter> delete(Integer id) {
        Result<Chapter> result = new Result<>();
        chapterDAO.delete(id);
        result.setResultSuccess("success",chapterDAO.getById(id));
        return result;
    }

    @Override
    public Result<Chapter> getById(Integer id) {
        Result<Chapter> result = new Result<>();
        result.setResultSuccess("success", chapterDAO.getById(id));
        return result;
    }

    @Override
    public Result<Chapter> update(Chapter chapter) {
        Result<Chapter> result = new Result<>();
        chapterDAO.update(chapter);
        result.setResultSuccess("success", chapterDAO.getById(chapter.getId()));
        return result;
    }
}
