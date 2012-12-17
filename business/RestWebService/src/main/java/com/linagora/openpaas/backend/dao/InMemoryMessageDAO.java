package com.linagora.openpaas.backend.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

import com.linagora.openpaas.backend.dto.Message;
import com.linagora.openpaas.backend.dto.User;


public class InMemoryMessageDAO implements MessageDAO {
	
	private Map<User, Queue<Message>> map;
	
	private final int MAX = 50;
	
	public InMemoryMessageDAO(){
		map = new HashMap<User, Queue<Message>>();
	}


	@Override
	public void create(Message message, User user) {
		
		Queue<Message> messagelist = map.get(user);
		
		if(messagelist==null){
			messagelist = new ArrayBlockingQueue<Message>(MAX);
		}
		
		message.setId(UUID.randomUUID().toString());
		messagelist.add(message);
		map.put(user, messagelist);
	}


	@Override
	public List<Message> findAvailableMessage(User user) {
		
		List<Message> res = null;
		
		Queue<Message> messagelist = map.get(user);
		if(messagelist!=null) res = Collections.unmodifiableList(new ArrayList<Message>(messagelist));
		
		return res;
		
	}


	@Override
	public int getMessagesNumber(User user) {
		
		Queue<Message> messagelist = map.get(user);
		if(messagelist==null) return 0;
		else return messagelist.size();
	}

}
