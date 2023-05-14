package com.course_registration.controller;

import com.course_registration.model.Course;
import com.course_registration.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @PutMapping("/course/{id}")
    public Course updateCourse(@PathVariable Long id,@RequestBody Course course){
       return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
