package org.cweili.drivingtest.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 错题记录
 * 
 * @author Cweili
 * @version 2013-3-28 下午12:14:33
 * 
 */
@Document(collection = "record")
public class Record {

	@Id
	private String user;
	private Set<String> wrongQuestion;

	public Record() {
		super();
	}

	@PersistenceConstructor
	public Record(String user, Set<String> wrongQuestion) {
		super();
		this.user = user;
		this.wrongQuestion = wrongQuestion;
	}

	public String getUser() {
		return user;
	}

	public Set<String> getWrongQuestion() {
		return wrongQuestion;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setWrongQuestion(Set<String> wrongQuestion) {
		this.wrongQuestion = wrongQuestion;
	}

}
