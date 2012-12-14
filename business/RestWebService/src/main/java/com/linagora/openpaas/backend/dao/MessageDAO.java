package com.linagora.openpaas.backend.dao;

import java.util.List;

import com.linagora.openpaas.backend.dto.Message;

public interface MessageDAO {

	public List<Message> findAvailableMessage();
	public void create(Message message);
	public int getMessagesNumber();

}
