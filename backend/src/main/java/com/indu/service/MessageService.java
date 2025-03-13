package com.indu.service;

import java.util.List;

import com.indu.exception.ChatException;
import com.indu.exception.ProjectException;
import com.indu.exception.UserException;
import com.indu.model.Message;

public interface MessageService {

    Message sendMessage(Long senderId, Long chatId, String content) throws UserException, ChatException, ProjectException;

    List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException;
}

