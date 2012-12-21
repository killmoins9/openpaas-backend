package com.linagora.openpaas.backend.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.linagora.openpaas.backend.storage.User;


@XmlRootElement(name="user")
@JsonRootName(value="user")
public class UserVO {
	
	private String login;
	private String firstname;
	private String lastname;
	private String mail;
	
	public UserVO(User user){
		if(user==null) return;
		
		this.login = user.getLogin();
		this.firstname= user.getFirstname();
		this.lastname = user.getLastname();
		this.mail = user.getMail();
	}
	
	public UserVO() {
	}

	public String getLogin() {
		return login;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
