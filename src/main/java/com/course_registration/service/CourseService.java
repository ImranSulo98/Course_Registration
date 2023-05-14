package com.course_registration.service;

import com.course_registration.model.Course;

import java.util.List;

public interface CourseService {

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    Course createCourse(Course course);

    Course updateCourse(Long id, Course newCourse);

    void deleteCourse(Long id);
}
