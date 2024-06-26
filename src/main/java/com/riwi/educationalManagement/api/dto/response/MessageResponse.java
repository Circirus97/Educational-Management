package com.riwi.educationalManagement.api.dto.response;

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
public class MessageResponse {
    private Long id;
    private String messageContent;
    private LocalDateTime sentDate;
    private UserInfoResponse userSender;
    private UserInfoResponse userReceiver;
}
