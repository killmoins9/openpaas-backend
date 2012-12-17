package com.linagora.openpaas.backend.dao;

import java.util.List;

import com.linagora.openpaas.backend.dto.User;

public interface UserDAO {

	public User getUser(String userid);
	
	public User create(User user);
	public List<User> findAll();

}
