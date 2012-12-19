package com.linagora.openpaas.backend.service;

import java.util.Set;

public interface AuthenticationService {

	String check(String username);

	Set<String> getRoles(String username);


	Set<String> getPermissions(String username);

	
	
}
