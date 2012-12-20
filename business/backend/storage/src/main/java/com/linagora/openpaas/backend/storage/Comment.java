package com.linagora.openpaas.backend.storage;

import java.util.Calendar;

import org.bson.types.ObjectId;
import com.google.common.base.Objects;

public class Comment {
	
	private ObjectId _id;
	private String content;
	private User author;
	private Calendar createDate;
	
	
	public Comment() {
		super();
	}


	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("_id", _id)
			.toString();
	}


	public ObjectId get_id() {
		return _id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public Calendar getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}
	
}
