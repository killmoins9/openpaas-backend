package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dto.User;

public interface ManageUserService {

	public void create(User u);
	public List<User> findAll();
	public User getUser(String id);
	
}
