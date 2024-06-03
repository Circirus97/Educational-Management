package com.riwi.educationalManagement.infraestructure.abstract_service;

import com.riwi.educationalManagement.api.dto.request.CourseRequest;
import com.riwi.educationalManagement.api.dto.response.CourseToUserResponse;
import com.riwi.educationalManagement.api.dto.response.UserAndCourseResponse;
import com.riwi.educationalManagement.domain.entities.Course;

import java.util.List;

public interface ICourseService extends CrudServices<CourseRequest, CourseToUserResponse, Long>{
    List<Course> findAllByCourseName(String courseName);
}
