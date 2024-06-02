package com.riwi.educationalManagement.api.controller;

import com.riwi.educationalManagement.api.dto.request.EnrollmentRequest;
import com.riwi.educationalManagement.api.dto.response.EnrollmentResponse;
import com.riwi.educationalManagement.infraestructure.abstract_service.IEnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/enrollments")
@AllArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService iEnrollmentService;

    @GetMapping
    public ResponseEntity<Page<EnrollmentResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){

        return  ResponseEntity.ok(this.iEnrollmentService.getAll(page -1, size));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EnrollmentResponse> get(@PathVariable Long id){

        return ResponseEntity.ok(this.iEnrollmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> create(
            @Validated
            @RequestBody EnrollmentRequest request){

        return ResponseEntity.ok(this.iEnrollmentService.create(request));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<EnrollmentResponse> update(
            @Validated
            @RequestBody EnrollmentRequest request,
            @PathVariable Long id){

        return ResponseEntity.ok(this.iEnrollmentService.update(request, id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        this.iEnrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
