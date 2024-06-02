package com.riwi.educationalManagement.api.dto.request;

import com.riwi.educationalManagement.domain.entities.Course;
import com.riwi.educationalManagement.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {

    private LocalDateTime enrollmentDate;

    private Long userId;

    private Long courseId;
}
