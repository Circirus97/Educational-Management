package com.riwi.educationalManagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

//Para configurar beans dentro de spring
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Api to manage students and their courses",
                version = "1.0",
                description =
                        "Online learning management system that allows RIWI to efficiently store and manage courses, users, evaluations and\n" +
                                "to efficiently store and manage courses, users, assessments, and student and faculty communications.\n" +
                                "between students and teachers."
        )

)
public class OpenApiConfig {
}
