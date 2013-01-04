package com.linagora.openpaas.backend.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.bson.types.ObjectId;

import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.storage.Message;
import com.linagora.openpaas.backend.storage.User;

public class InMemoryMessageDAO implements MessageDAO {

	private Map<User, Queue<Message>> map;

	private final int MAX = 50;

	public InMemoryMessageDAO() {
		map = new HashMap<User, Queue<Message>>();
	}

	@Override
	public Message create(Message message, User user) {

		Queue<Message> messagelist = map.get(user);

		if (messagelist == null) {
			messagelist = new ArrayBlockingQueue<Message>(MAX);
		}

		messagelist.add(message);
		map.put(user, messagelist);
		return message;
	}

	@Override
	public List<Message> findAvailableMessage(User user) {

		List<Message> res = null;

		Queue<Message> messagelist = map.get(user);
		if (messagelist != null)
			res = Collections.unmodifiableList(new ArrayList<Message>(
					messagelist));

		return res;

	}

	@Override
	public long getMessagesNumber(User user) {

		Queue<Message> messagelist = map.get(user);
		if (messagelist == null)
			return 0;
		else
			return messagelist.size();
	}

	@Override
	public Message getMessage(String id, User user) {
		Message res = null;

		Queue<Message> messagelist = map.get(user);

		for (Message message : messagelist) {

			if (message.getId().equals(id)) {
				res = message;
				break;
			}
		}

		return res;
	}
	
	
	@Override
	public Message getMessage(ObjectId id, User u) {
		return getMessage(id.toString(),u);
	}
	
	
	@Override
	public void delete(Message message) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	@Override
	public MessageVO convertToDto(Message m) {
		return new MessageVO(m);
	}

	@Override
	public List<MessageVO> convertToDto(List<Message> l) {
		if(l==null) return null;
		
		List<MessageVO> vos = new ArrayList<MessageVO>(l.size());
		for (Message m : l) {
			vos.add(convertToDto(m));
		}
		return vos;
	}

	@Override
	public Message convert(MessageVO m) {
		Message me = new Message();
		me.setBody(m.getBody());
		me.setSubject(m.getSubject());
		if(m.getId()!=null) me.setId(new ObjectId(m.getId()));
		return me;
	}



}
