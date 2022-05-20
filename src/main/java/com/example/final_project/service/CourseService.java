package com.example.final_project.service;

import com.example.final_project.dto.CourseRequest;
import com.example.final_project.dto.CourseResponse;
import com.example.final_project.model.AppUser;
import com.example.final_project.model.Course;
import com.example.final_project.repo.AppUserRepository;
import com.example.final_project.repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    public final CourseRepository repository;
    public final AppUserRepository appUserRepository;


    public CourseResponse create(CourseRequest request){
        Course course = mapToEntity(request);
        repository.save(course);
        return viewEntity(course);
    }

    public CourseResponse getCourseById(long id){
        Course course = repository.findById(id).get();
        repository.save(course);
        return viewEntity(course);
    }

    public CourseResponse updateCourseById(long id,CourseRequest request){
        Course course = repository.findById(id).get();
        editEntity(course,request);
        repository.save(course);
        return viewEntity(course);
    }
    public void deleteCourseById(long id){
        Course course = repository.findById(id).get();
        repository.delete(course);
    }

    public List<CourseResponse> getAllCourses(){
        return viewAllCourse(repository.findAll());
    }

    public Course mapToEntity(CourseRequest request){
        Course course = new Course();
        course.setCourseName(request.getCourseName());

        AppUser appUser = appUserRepository.findById(request.getAppUserId()).get();
        course.setAppUser(appUser);
        return course;
    }

    public Course editEntity(Course course,CourseRequest request){
        course.setCourseName(request.getCourseName());

        AppUser appUser = appUserRepository.findById(request.getAppUserId()).get();
        course.setAppUser(appUser);
        return course;
    }

    public CourseResponse viewEntity(Course course){
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCourseName(course.getCourseName());
        response.setStartDate(course.getStartDate());
        response.setAppUserName(course.getAppUser().getName());
        return response;
    }

    public List<CourseResponse> viewAllCourse (List<Course> listOfCourses){
        List<CourseResponse> courseResponseList = new ArrayList<>();
        for (Course getEachMemberOfCourseList:listOfCourses
             ) {
            courseResponseList.add(viewEntity(getEachMemberOfCourseList));
        }
        return courseResponseList;
    }
}
