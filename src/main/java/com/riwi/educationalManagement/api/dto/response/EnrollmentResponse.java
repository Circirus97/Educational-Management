package com.riwi.educationalManagement.api.dto.response;

import com.riwi.educationalManagement.domain.entities.Course;
import com.riwi.educationalManagement.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {

    private Long id;

    private LocalDateTime enrollmentDate;

    private Long userId;

    private Long courseId;
}
