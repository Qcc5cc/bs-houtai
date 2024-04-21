package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    Result<Course> add(Course course);
    Result<Course> delete(Integer id);
    Result<Course> update(Course course) throws Exception;
    Result<List<Course>> getCourses();
    Result<Integer> stuAddCourse(Integer stuId,Integer courseId);
    Result<Boolean> search(Integer stuId,Integer courseId);
    Result<List<Course>>  getMyCourses(Integer stuId);

    Result<List<Course>> getSwiperCourses();
    Result<List<Course>>  getOwnedCourses(Integer teacherId);
    Result<Course>  getCourseById(Integer id);
}
