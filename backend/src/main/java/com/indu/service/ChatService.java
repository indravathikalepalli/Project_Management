package com.indu.service;

import java.util.List;

import com.indu.exception.ChatException;
import com.indu.exception.ProjectException;
import com.indu.model.Chat;

public interface ChatService {

	Chat createChat(Chat chat) ;

	//Chat getChatsByProjectId(Long projectId) throws ChatException, ProjectException;

//	Chat addUsersToChat(Long chatId, List<Long> userIds) throws ChatException;

	
//	 List<Chat> searchChatsByName(String name) throws ChatException;

	// Other methods as needed
}
