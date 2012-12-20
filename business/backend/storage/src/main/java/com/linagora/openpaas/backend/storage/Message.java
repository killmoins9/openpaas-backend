package com.linagora.openpaas.backend.storage;

import java.util.Calendar;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.common.base.Objects;

public class Message {
	
	private ObjectId _id;
	private String body;
	private String subject;
	private User user;
	
	private Calendar createDate;
	private Calendar editDate;
	private Calendar sentDate;
	
	private List<Comment> comments;
	private List<Edit> editions;
	
	
	public Message() {
		super();
	}


	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("_id", _id)
			.add("subject", subject)
			.toString();
	}


	public ObjectId get_id() {
		return _id;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Calendar getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}


	public Calendar getEditDate() {
		return editDate;
	}


	public void setEditDate(Calendar editDate) {
		this.editDate = editDate;
	}


	public Calendar getSentDate() {
		return sentDate;
	}


	public void setSentDate(Calendar sentDate) {
		this.sentDate = sentDate;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public List<Edit> getEditions() {
		return editions;
	}


	public void setEditions(List<Edit> editions) {
		this.editions = editions;
	}
	
}
