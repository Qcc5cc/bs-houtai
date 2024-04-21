package com.example.demo.api;

import cn.hutool.json.JSONObject;
import com.example.demo.entity.Chapter;
import com.example.demo.entity.Course;
import com.example.demo.model.Result;
import com.example.demo.service.ChapterService;
import com.example.demo.service.CourseService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/chapter")
public class ChapterAPI {
    @Autowired 
    private ChapterService chapterService;

    @GetMapping("/getChaptersByCourseId")
    public Result<List<Chapter>> getChapters(@RequestParam Integer course_id){
        return  chapterService.getChaptersByCourseId(course_id);
    }

    @PostMapping("/addFile")
    public String addFile(@RequestParam("file") MultipartFile file){
        JSONObject object=new JSONObject();

            String fileName = file.getOriginalFilename();  // 文件名
            File dest = new File("D:/upload/video" +'/'+ fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (Exception e) {
                System.out.println(e);
                object.put("success",2);
                object.put("result","程序错误，请重新上传");
                return object.toString();
            }
        System.out.println("D:/upload/video" +'/'+ fileName);
        return "D:/upload/video" +'/'+ fileName;
    }

    @PostMapping("/add")
    public Result<Chapter> add(@RequestBody Chapter chapter){
        Result<Chapter> result;
        result = chapterService.add(chapter);
        return result;
    }

    @RequestMapping("/delete")
    public Result<Chapter> delete(@RequestParam(value = "id") Integer id){
        Result<Chapter> result;
        result = chapterService.delete(id);
        return result;
    }
    @PostMapping("/update")
    public Result<Chapter> update(@RequestBody Chapter chapter){
        Result<Chapter> result;
        result = chapterService.update(chapter);
        return result;
    }
}
