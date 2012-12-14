package com.linagora.openpaas.backend.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

import com.linagora.openpaas.backend.dto.Message;


public class InMemoryMessageDAO implements MessageDAO {
	
	private Queue<Message> messagelist;
	
	private final int MAX = 50;
	
	public InMemoryMessageDAO(){
		messagelist = new ArrayBlockingQueue<Message>(MAX);
	}


	@Override
	public void create(Message message) {
		message.setId(UUID.randomUUID().toString());
		messagelist.add(message);
	}


	@Override
	public List<Message> findAvailableMessage() {
		return Collections.unmodifiableList(new ArrayList<Message>(messagelist));
	}


	@Override
	public int getMessagesNumber() {
		return messagelist.size();
	}

}
