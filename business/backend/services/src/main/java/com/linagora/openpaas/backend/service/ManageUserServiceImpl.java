package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dao.InMemoryUserDAO;
import com.linagora.openpaas.backend.dao.UserDAO;
import com.linagora.openpaas.backend.dto.UserVO;
import com.linagora.openpaas.backend.storage.User;

public class ManageUserServiceImpl implements ManageUserService {

	private static UserDAO userDAO = new InMemoryUserDAO();

	@Override
	public void create(UserVO u) {
		User e  = userDAO.convert(u);
		userDAO.create(e);
	}

	@Override
	public List<UserVO> findAll() {
		List<User> l  = userDAO.findAll();
		return userDAO.convertToDto(l);
	}

	@Override
	public UserVO getUser(String login) {
		User e = userDAO.getUser(login);
		return userDAO.convertToDto(e);
	}
	
}
