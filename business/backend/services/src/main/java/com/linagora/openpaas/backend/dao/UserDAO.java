package com.linagora.openpaas.backend.dao;

import java.util.List;

import com.linagora.openpaas.backend.dto.UserVO;
import com.linagora.openpaas.backend.storage.User;

public interface UserDAO {

	public User getUser(String login);
	public User create(User user);
	public List<User> findAll();
	
	
	//transformations
	public UserVO convertToDto (User u);
	public List<UserVO> convertToDto (List<User> u);
	public User convert (UserVO u);

}
