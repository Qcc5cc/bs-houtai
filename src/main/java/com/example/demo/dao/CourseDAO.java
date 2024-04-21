package com.example.demo.dao;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDAO {
    int add(Course course);
    int delete(Integer id);
    int update(Course course);
    Course getById(Integer id);
    List<Course> getCourses();
    int stuAddCourse(Integer stuId,Integer courseId);
    List<Course> getMyCourses(Integer stuId);
//    int getByName(String course_name);
    List<Course> search(Integer stuId,Integer courseId);
    List<Course> getOwnedCourses(Integer teacherId);
}
