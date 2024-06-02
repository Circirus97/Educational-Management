package com.riwi.educationalManagement.api.controller;

import com.riwi.educationalManagement.api.dto.request.AssignmentRequest;
import com.riwi.educationalManagement.api.dto.response.CompleteAssignmentInfo;
import com.riwi.educationalManagement.infraestructure.abstract_service.IAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/assignments")
@AllArgsConstructor
@Tag(name = "Assignment")
public class AssignmentController {

    private final IAssignmentService iAssignmentService;

    @Operation(
            summary = "It is responsible for listing all assignments in paginated form",
            description = "You must submit the page and page size to receive all the corresponding assignments."
    )
    @GetMapping
    public ResponseEntity<Page<CompleteAssignmentInfo>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(this.iAssignmentService.getAll(page - 1, size));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CompleteAssignmentInfo> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.iAssignmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<CompleteAssignmentInfo> create(
            @Validated
            @RequestBody AssignmentRequest request) {

        return ResponseEntity.ok(this.iAssignmentService.create(request));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<CompleteAssignmentInfo> update(
            @Validated
            @RequestBody AssignmentRequest request,
            @PathVariable Long id) {

        return ResponseEntity.ok(this.iAssignmentService.update(request, id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.iAssignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
