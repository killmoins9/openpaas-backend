package com.linagora.openpaas.backend.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.crypto.hash.Sha256Hash;

import com.linagora.openpaas.backend.dto.UserVO;

public class AuthenticationServiceImpl implements AuthenticationService {

	private static ManageUserService manageUser = new ManageUserServiceImpl();

	@Override
	public String check(String username) {
		UserVO user = manageUser.getUser(username);
		if (user != null) {
			return encrypt("openpaas");
		} else {
			return null;
		}
	}

	@Override
	public Set<String> getRoles(String username) {
		Set<String> roles = new HashSet<String>();
		roles.add("openpaas");
		return roles;
	}

	@Override
	public Set<String> getPermissions(String username) {
		Set<String> permissions = new HashSet<String>();
		permissions.add("message:*");// webservice messageService grant all 										// access
		permissions.add("user:*");// webservice userService grant all access
		return permissions;
	}

	private static String encrypt(String password) {
		// string like this  0357513deb903a056e74a7e475247fc1ffe31d8be4c1d4a31f58dd47ae484100
		return new Sha256Hash(password).toString();
	}

}
