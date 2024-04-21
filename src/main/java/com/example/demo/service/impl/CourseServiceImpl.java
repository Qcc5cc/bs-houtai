package com.example.demo.service.impl;

import com.example.demo.dao.CourseDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.model.Result;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;
    @Override
    public Result<Course> add(Course course) {
        Result<Course> result = new Result<>();
        courseDAO.add(course);
        result.setResultSuccess("添加成功！", course);
        return result;
    }

    @Override
    public Result<Course> delete(Integer id) {
        Result<Course> result = new Result<>();
        courseDAO.delete(id);
        result.setResultSuccess("删除成功！", courseDAO.getById(id));
        return result;
    }

    @Override
    public Result<Course> update(Course course) throws Exception {
        Result<Course> result = new Result<>();
        courseDAO.update(course);
        result.setResultSuccess("更新成功！", course);
        return result;
    }

    @Override
    public Result<List<Course>> getCourses() {
        List<Course> data;
        Result<List<Course>> result = new Result<>();
        data = courseDAO.getCourses();
        //  data.forEach(course -> course.setImageBlob(null));
        result.setResultSuccess("获取成功！", data);
        return result;
    }

    @Override
    public Result<Integer> stuAddCourse(Integer stuId,Integer courseId) {

        Result<Integer> result =new Result<>();
        Integer r = courseDAO.stuAddCourse(stuId,courseId);
        result.setResultSuccess("success",r);
        return result;
    }

    @Override
    public Result<Boolean> search(Integer stuId, Integer courseId) {
        Result<Boolean> result= new Result<>();
        if(courseDAO.search(stuId,courseId).isEmpty())
            result.setResultSuccess("success",true);
        else
            result.setResultSuccess("success",false);
        return result;
    }

    @Override
    public Result<List<Course>> getMyCourses(Integer stuId) {
        List<Course> list = courseDAO.getMyCourses(stuId);
        Result<List<Course>> result = new Result<>();
        result.setResultSuccess("success",list);
        return result;
    }

    @Override
    public Result<List<Course>> getSwiperCourses() {
        List<Course> data;
        Result<List<Course>> result = new Result<>();
        data = courseDAO.getCourses().subList(0,5);
//        data = courseDAO.getCourses();

        //  data.forEach(course -> course.setImageBlob(null));
        result.setResultSuccess("获取成功！", data);
        return result;
    }

    @Override
    public Result<List<Course>> getOwnedCourses(Integer teacherId) {
        List<Course> list = courseDAO.getOwnedCourses(teacherId);
        Result<List<Course>> result = new Result<>();
        result.setResultSuccess("success",list);
        return result;
    }

    @Override
    public Result<Course> getCourseById(Integer id) {
        Result<Course> result = new Result<>();
        result.setResultSuccess("获取成功！", courseDAO.getById(id));
        return result;
    }
}
