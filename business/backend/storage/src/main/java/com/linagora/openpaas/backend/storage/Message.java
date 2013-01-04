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
		_id = ObjectId.get();
	}


	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("_id", _id)
			.add("subject", subject)
			.toString();
	}


	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}
	
	
}
