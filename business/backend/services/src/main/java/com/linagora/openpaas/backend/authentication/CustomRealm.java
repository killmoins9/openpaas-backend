package com.linagora.openpaas.backend.authentication;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.linagora.openpaas.backend.service.AuthenticationService;
import com.linagora.openpaas.backend.service.AuthenticationServiceImpl;

public class CustomRealm extends AuthorizingRealm {


	AuthenticationService authenticationService = new AuthenticationServiceImpl();
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		checkNotNull(username, "Null usernames are not allowed by this realm.");
		String password = authenticationService.check(username);
		checkNotNull(password, "No account found for user [" + username + "]");
		return new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
	}

	private void checkNotNull(Object reference, String message) {
		if (reference == null) {
			throw new AuthenticationException(message);
		}
	}

	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        checkNotNull(principals, "PrincipalCollection method argument cannot be null.");
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(authenticationService.getRoles(username));
        info.setStringPermissions(authenticationService.getPermissions(username));
        return info;
    }
}