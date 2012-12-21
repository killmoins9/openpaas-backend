package com.linagora.openpaas.backend.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linagora.openpaas.backend.dto.UserVO;
import com.linagora.openpaas.backend.storage.User;



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
	public User getUser(String login) {
		return map.get(login);
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

	@Override
	public UserVO convertToDto(User u) {
		return new UserVO(u);
	}

	@Override
	public User convert(UserVO u) {
		User e = new User();
		e.setFirstname(u.getFirstname());
		e.setLastname(u.getLastname());
		e.setLogin(u.getLogin());
		e.setMail(u.getMail());
		return e;
	}

	@Override
	public List<UserVO> convertToDto(List<User> l) {
		List<UserVO> vos = new ArrayList<UserVO>(l.size());
		for (User user : l) {
			vos.add(convertToDto(user));
		}
		return vos;
	}

}
