package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dao.InMemoryUserDAO;
import com.linagora.openpaas.backend.dao.UserDAO;
import com.linagora.openpaas.backend.dto.User;

public class ManageUserServiceImpl implements ManageUserService {

	private static UserDAO userDAO = new InMemoryUserDAO();

	@Override
	public void create(User u) {
		userDAO.create(u);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User getUser(String id) {
		return userDAO.getUser(id);
	}
	
}
