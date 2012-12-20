package com.linagora.openpaas.backend.storage;

import org.bson.types.ObjectId;
import com.google.common.base.Objects;

public class User {
	private ObjectId _id;
	private String login;
	private String firstname;
	private String lastname;
	private String mail;
	private User responsable;
	
	
	public User() {
		super();
	}

	public User(String login) {
		super();
		this.login = login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(login);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof User) {
			User that = (User) object;
			return Objects.equal(this.login, that.login);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("_id", _id)
			.add("login", login)
			.toString();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}
	
}
