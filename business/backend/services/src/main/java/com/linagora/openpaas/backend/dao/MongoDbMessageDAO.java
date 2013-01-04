package com.linagora.openpaas.backend.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.google.common.collect.Lists;
import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.storage.Message;
import com.linagora.openpaas.backend.storage.User;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class MongoDbMessageDAO implements MessageDAO {

	
	private MongoCollection messagesCollection;
	
	public MongoDbMessageDAO() throws UnknownHostException {
		this(DEFAULT_IP, DEFAULT_PORT, DEFAULT_DB_NAME, DEFAULT_COLLECTION_NAME);
	}
	
	public MongoDbMessageDAO(String ip, Integer port) throws UnknownHostException {
		this(ip, port, DEFAULT_DB_NAME, DEFAULT_COLLECTION_NAME);
	}
	
	public MongoDbMessageDAO(String ip, Integer port, String dbName,
			String mediaCollectionName) throws UnknownHostException {
		Mongo mongo = new Mongo(ip, port);
		DB db = mongo.getDB(dbName);

		Jongo jongo = new Jongo(db);
		this.messagesCollection = jongo.getCollection(mediaCollectionName);
	}
	
	
	
	@Override
	public List<Message> findAvailableMessage(User user) {
		Iterable<Message> medias = this.messagesCollection.find("{user : #}", user).as(Message.class);
		return Lists.newArrayList(medias);
	}
	

	@Override
	public long getMessagesNumber(User user) {
		return this.messagesCollection.count();
	}

	@Override
	public Message create(Message message, User user) {
		this.messagesCollection.save(message);
		return message;
	}
	
	@Override
	public void delete(Message message) {
		if (message == null || message.getId() == null) {
			throw new IllegalArgumentException(
					"Media or media id can't be null : " + message);
		}

		this.messagesCollection.remove(message.getId());
	}
	
	
	
	@Override
	public Message getMessage(ObjectId id, User u) {
		return this.messagesCollection.findOne(id).as(Message.class);
	}

	@Override
	public Message getMessage(String id, User u) {
		ObjectId ob = new ObjectId(id);
		return getMessage(ob, u);
	}
	
	// transformations
	
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
