package com.linagora.openpaas.backend.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linagora.openpaas.backend.dto.User;


public class InMemoryUserDAO implements UserDAO {
	
	private Map<String, User> map;
	
	
	public InMemoryUserDAO(){
		map = new HashMap<String, User>();
		
		User u = new User();
		u.setFirstname("user1");
		u.setLastname("user1");
		u.setLogin("user1");
		u.setMail("user1@openpaas.org");
		map.put("user1", u);
	}

	@Override
	public User getUser(String userid) {
		return map.get(userid);
	}

	@Override
	public User create(User user) {
		map.put(user.getLogin(), user);
		return user;
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<User>(map.values());
	}

}
