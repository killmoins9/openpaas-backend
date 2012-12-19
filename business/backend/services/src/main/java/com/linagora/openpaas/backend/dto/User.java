package com.linagora.openpaas.backend.dto;



public class User {
	
	private String login;
	private String firstname;
	private String lastname;
	private String mail;
	
	public User(com.linagora.openpaas.backend.storage.User user){
		this.login = user.getLogin();
		this.firstname= user.getFirstname();
		this.lastname = user.getLastname();
		this.mail = user.getMail();
	}
	
	public User() {
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
