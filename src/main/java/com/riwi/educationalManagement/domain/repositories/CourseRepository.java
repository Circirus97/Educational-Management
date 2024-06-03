package com.riwi.educationalManagement.domain.repositories;

import com.riwi.educationalManagement.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //Solo puede devolverme los datos que hay en parametros <>
    List<Course> findAllByCourseNameLike(String courseName);


}
