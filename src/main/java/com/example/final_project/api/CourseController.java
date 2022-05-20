package com.example.final_project.api;


import com.example.final_project.dto.CourseRequest;
import com.example.final_project.dto.CourseResponse;
import com.example.final_project.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/course")
public class CourseController {

    private final CourseService service;

    @GetMapping()
    public List<CourseResponse> getAllCourse(){
        return service.getAllCourses();
    }

    @PostMapping("/create")
    public CourseResponse createCourse(@RequestBody CourseRequest request){
        return service.create(request);
    }
    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable long id){
        return service.getCourseById(id);
    }
    @PutMapping("update/{id}")
    public CourseResponse updateCourse(@PathVariable long id, @RequestBody CourseRequest request){
        return service.updateCourseById(id,request);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id){
        service.deleteCourseById(id);
    }
}
