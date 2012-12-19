package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dao.InMemoryMessageDAO;
import com.linagora.openpaas.backend.dao.MessageDAO;
import com.linagora.openpaas.backend.dto.Message;
import com.linagora.openpaas.backend.dto.User;

public class ManageMessageServiceImpl implements ManageMessageService {

	private static MessageDAO dao = new InMemoryMessageDAO();
	
	@Override
	public void create(Message message, User u) {
		dao.create(message, u);
	}

	@Override
	public List<Message> findAvailableMessage(User u) {
		return dao.findAvailableMessage(u);
	}

	@Override
	public int getMessagesNumber(User u) {
		return dao.getMessagesNumber(u);
	}

	@Override
	public Message getMessage(String id, User u) {
		return dao.getMessage(id, u);
	}

}
