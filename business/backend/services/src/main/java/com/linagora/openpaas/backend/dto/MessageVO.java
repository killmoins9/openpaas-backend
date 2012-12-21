package com.linagora.openpaas.backend.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.linagora.openpaas.backend.storage.Message;


@XmlRootElement(name="message")
public class MessageVO {
	
	private String id;
	private String body;
	private String subject;
	

	public MessageVO() {
	}
	public MessageVO(Message m) {
		if(m==null) return;
		
		this.body = m.getBody();
		this.subject = m.getSubject();
		this.id = m.get_id().toString();
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

	
}
