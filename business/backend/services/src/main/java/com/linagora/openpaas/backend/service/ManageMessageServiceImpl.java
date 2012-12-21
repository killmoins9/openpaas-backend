package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dao.InMemoryMessageDAO;
import com.linagora.openpaas.backend.dao.InMemoryUserDAO;
import com.linagora.openpaas.backend.dao.MessageDAO;
import com.linagora.openpaas.backend.dao.UserDAO;
import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.dto.UserVO;
import com.linagora.openpaas.backend.storage.Message;
import com.linagora.openpaas.backend.storage.User;

public class ManageMessageServiceImpl implements ManageMessageService {

	private static MessageDAO dao = new InMemoryMessageDAO();
	private static UserDAO daouser = new InMemoryUserDAO();
	
	@Override
	public void create(MessageVO message, UserVO u) {
		Message me = dao.convert(message);
		User ue = daouser.convert(u);
		dao.create(me, ue);
	}

	@Override
	public List<MessageVO> findAvailableMessage(UserVO u) {
		User ue = daouser.convert(u);
		List<Message> l = dao.findAvailableMessage(ue);
		return dao.convertToDto(l);
	}

	@Override
	public int getMessagesNumber(UserVO u) {
		User ue = daouser.convert(u);
		return dao.getMessagesNumber(ue);
	}

	@Override
	public MessageVO getMessage(String id, UserVO u) {
		User ue = daouser.convert(u);
		Message me = dao.getMessage(id, ue);
		return dao.convertToDto(me);
	}

}
