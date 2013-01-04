package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dto.MessageVO;
import com.linagora.openpaas.backend.dto.UserVO;

public interface ManageMessageService {

	public void create(MessageVO message, UserVO u);
	public List<MessageVO> findAvailableMessage(UserVO u);
	public long getMessagesNumber(UserVO u);
	public MessageVO getMessage(String id, UserVO u);
}
