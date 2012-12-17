package com.linagora.openpaas.backend.dao;

import java.util.List;

import com.linagora.openpaas.backend.dto.Message;
import com.linagora.openpaas.backend.dto.User;

public interface MessageDAO {

	public List<Message> findAvailableMessage(User user);
	public int getMessagesNumber(User user);
	public void create(Message message, User user);

}
