package com.riwi.educationalManagement.api.controller;

import com.riwi.educationalManagement.api.dto.request.CourseRequest;
import com.riwi.educationalManagement.api.dto.response.CourseAndUsersResponse;
import com.riwi.educationalManagement.api.dto.response.CourseToUserResponse;
import com.riwi.educationalManagement.domain.entities.Course;
import com.riwi.educationalManagement.infraestructure.abstract_service.ICourseService;
import com.riwi.educationalManagement.infraestructure.abstract_service.IEnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    private final IEnrollmentService iEnrollmentService;


     @GetMapping
    public ResponseEntity<Page<CourseToUserResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){
        return  ResponseEntity.ok(this.courseService.getAll(page -1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CourseToUserResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.courseService.get(id));
    }

    @PostMapping
    public ResponseEntity<CourseToUserResponse> create(@Validated @RequestBody CourseRequest request){
        return ResponseEntity.ok(this.courseService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CourseToUserResponse> update(
            @Validated
            @RequestBody CourseRequest request,
            @PathVariable Long id){

        return ResponseEntity.ok(this.courseService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{course_id}/users")
    public ResponseEntity<CourseAndUsersResponse> getAllUserByCourseId(
            @Validated
            @PathVariable(name = "course_id") Long courseId
    ){

        CourseAndUsersResponse courseAndUsersResponse =  this.iEnrollmentService.getAllUserByCourseId(courseId);
        if (courseAndUsersResponse.getId() == null) {
            return ResponseEntity.noContent().build();
        }
         return ResponseEntity.ok(this.iEnrollmentService.getAllUserByCourseId(courseId));
    }

    @GetMapping(path = "/courseName/{courseName}")
    public ResponseEntity<List<Course>> getAllCourseByCourseName(
            @PathVariable String courseName
    ){
         return ResponseEntity.ok(this.courseService.findAllByCourseName(courseName));
    }
}
