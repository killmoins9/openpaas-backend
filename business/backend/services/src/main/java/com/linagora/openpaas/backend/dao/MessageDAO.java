package com.linagora.openpaas.backend.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.storage.Message;
import com.linagora.openpaas.backend.storage.User;

public interface MessageDAO {

	
	public final static String DEFAULT_IP = "127.0.0.1";
	public final static Integer DEFAULT_PORT = 27017;
	public final static String DEFAULT_DB_NAME = "openpaasDB";
	public final static String DEFAULT_COLLECTION_NAME = "message";
	
	
	public List<Message> findAvailableMessage(User user);
	public long getMessagesNumber(User user);
	public Message create(Message message, User user);
	public Message getMessage(String id, User u);
	public Message getMessage(ObjectId id, User u);
	public void delete(Message message);
	
	
	//transformations
	public MessageVO convertToDto (Message m);
	public List<MessageVO> convertToDto (List<Message> l);
	public Message convert (MessageVO m);
	

}
