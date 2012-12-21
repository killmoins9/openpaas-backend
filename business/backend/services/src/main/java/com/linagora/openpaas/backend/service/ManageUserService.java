package com.linagora.openpaas.backend.service;

import java.util.List;

import com.linagora.openpaas.backend.dto.UserVO;

public interface ManageUserService {

	public void create(UserVO u);
	public List<UserVO> findAll();
	public UserVO getUser(String login);
	
}
