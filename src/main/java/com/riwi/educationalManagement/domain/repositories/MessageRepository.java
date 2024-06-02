package com.riwi.educationalManagement.domain.repositories;

import com.riwi.educationalManagement.api.dto.response.UserInfoResponse;
import com.riwi.educationalManagement.domain.entities.Message;
import com.riwi.educationalManagement.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

    List<Message> findAllByMessageSenderAndMessageReceiver(UserInfoResponse userSender, UserInfoResponse userReceiver);
}
