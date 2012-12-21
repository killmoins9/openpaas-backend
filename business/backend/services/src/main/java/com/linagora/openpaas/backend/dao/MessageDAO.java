package com.linagora.openpaas.backend.dao;

import java.util.List;

import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.storage.Message;
import com.linagora.openpaas.backend.storage.User;

public interface MessageDAO {

	public List<Message> findAvailableMessage(User user);
	public int getMessagesNumber(User user);
	public void create(Message message, User user);
	public Message getMessage(String id, User u);
	
	
	//transformations
	public MessageVO convertToDto (Message m);
	public List<MessageVO> convertToDto (List<Message> l);
	public Message convert (MessageVO m);
}
