package com.riwi.educationalManagement.api.dto.request;

import com.riwi.educationalManagement.domain.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotBlank(message = "The course name is required")
    private String courseName;

    private String description;

    private Long instructorId;
}
