package com.example.demo.api;

import com.example.demo.entity.Course;
import com.example.demo.model.Result;
import com.example.demo.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseAPI {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Result<Course> register(@RequestBody Course course) throws IOException {
        Result<Course> result;
        result = courseService.add(course);
        return result;
    }

    @GetMapping("/getCourses")
    public Result<List<Course>> getCourses() {
        Result<List<Course>> result;
        result = courseService.getCourses();
        return result;
    }

    @PostMapping("/delete")
    public Result<Course> delete(@RequestBody Integer id) {
        Result<Course> result;
        result = courseService.delete(id);
        return result;
    }

    @PostMapping("/update")
    public Result<Course> update(@RequestBody Course course)  throws Exception{
        Result<Course> result;
        result = courseService.update(course);
        return result;
    }

    @GetMapping("/getImage")
    public Result<String> getImage(@RequestParam String imageUrl){
        System.out.println(imageUrl);
        //String imageUrl = course.getImageUrl();
        Result<String> result = new Result<>();
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imageUrl);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        imageUrl = Base64.encodeBase64String(data);
        result.setResultSuccess("success",imageUrl);
        return result;
    }

    @RequestMapping(value ="/getFileSrc" ,method = RequestMethod.GET)
    @ResponseBody
    public void getFileSrc(HttpServletRequest request , HttpServletResponse response, @RequestParam(value="path") String path) throws IOException{
        File file = new File(path);
        //System.out.println(path);
        FileInputStream input = new FileInputStream(file);
        int i = input.available();
        byte[] bytes = new byte[i];
        input.read(bytes);
        response.setContentType("application/video");
        OutputStream output = response.getOutputStream();
        try {
            output.write(bytes);
        }catch (IOException e){
            output.flush();
            output.close();
            input.close();
        }
        output.flush();
        output.close();
        input.close();
    }
    @RequestMapping("/stuAddCourse")
    public Result<Integer> stuAddCourse(@RequestParam(value="stuId") Integer stuId,@RequestParam(value="courseId") Integer courseId) {
        Result<Integer> result;
        result = courseService.stuAddCourse(stuId,courseId);
        return result;
    }
    @RequestMapping("/search")
    public Result<Boolean> search(@RequestParam(value="stuId") Integer stuId,@RequestParam(value="courseId") Integer courseId) {
        Result<Boolean> result;
        result = courseService.search(stuId,courseId);
        return result;
    }
    @GetMapping("/getMyCourses")
    public Result<List<Course>> getMyCourses(@RequestParam(value="stuId") Integer stuId) {
        Result<List<Course>> result;
        result = courseService.getMyCourses(stuId);
        return result;
    }

    @GetMapping("/getSwiperCourses")
    public Result<List<Course>> getSwiperCourses() {
        Result<List<Course>> result;
        result = courseService.getSwiperCourses();
        return result;
    }
    @GetMapping("/getOwnedCourses")
    public Result<List<Course>> getOwnedCourses(@RequestParam(value="teacherId") Integer teacherId) {
        Result<List<Course>> result;
        result = courseService.getOwnedCourses(teacherId);
        return result;
    }
    @GetMapping("/getCourseById")
    public Result<Course> getCourseById(@RequestParam(value="id") Integer id) {
        Result<Course> result;
        result = courseService.getCourseById(id);
        return result;
    }
}