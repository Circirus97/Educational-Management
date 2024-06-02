package com.riwi.educationalManagement.api.controller;

import com.riwi.educationalManagement.api.dto.request.MessageRequest;
import com.riwi.educationalManagement.api.dto.response.MessageResponse;
import com.riwi.educationalManagement.infraestructure.abstract_service.IMessageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/messages")
@AllArgsConstructor
public class MessageController {

    private final IMessageService iMessageService;

    @GetMapping
    public ResponseEntity<Page<MessageResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){

        return  ResponseEntity.ok(this.iMessageService.getAll(page -1, size));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<MessageResponse> get(@PathVariable Long id){

        return ResponseEntity.ok(this.iMessageService.get(id));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(
            @Validated
            @RequestBody MessageRequest request){

        return ResponseEntity.ok(this.iMessageService.create(request));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<MessageResponse> update(
            @Validated
            @RequestBody MessageRequest request,
            @PathVariable Long id){

        return ResponseEntity.ok(this.iMessageService.update(request, id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        this.iMessageService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/findMessage")
    public ResponseEntity<List<MessageResponse>> findAllMessageBySenderIdAndReceiverId(
            @Validated
            @RequestParam(name = "sender_id") Long senderId,
            @RequestParam(name = "receiver_id") Long receiverId
    ){

        return ResponseEntity.ok(this.iMessageService.findAllMessageBySenderIdAndReceiverId(senderId, receiverId));
    }

}
