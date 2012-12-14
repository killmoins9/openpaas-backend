package com.linagora.openpaas.backend.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
	
	private String id;
	private String body;
	private String subject;
	private String user;
	

	public Message() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	
}
