package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dto.Message;
import com.linagora.openpaas.backend.dto.User;

public interface ManageMessageService {

	public void create(Message message, User u);
	public List<Message> findAvailableMessage(User u);
	public int getMessagesNumber(User u);
	public Message getMessage(String id, User u);
}
