package com.riwi.educationalManagement.infraestructure.abstract_service;

import com.riwi.educationalManagement.api.dto.request.MessageRequest;
import com.riwi.educationalManagement.api.dto.response.MessageResponse;
import com.riwi.educationalManagement.domain.entities.Message;

import java.util.List;

public interface IMessageService extends CrudServices<MessageRequest, MessageResponse, Long>{

    List<MessageResponse> findAllMessageBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
