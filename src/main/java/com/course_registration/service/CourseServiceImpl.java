package com.course_registration.service;

import com.course_registration.model.Course;
import com.course_registration.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourseById(Long id) {
       return courseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
       return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course newCourse) {
        Course course = courseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        course.setName(newCourse.getName());
        course.setDescription(newCourse.getDescription());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
        courseRepository.deleteById(id);
    }
}
