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
	private Set<String> wrongOnce;
	private Set<String> wrongTwice;

	public Record() {
		super();
	}

	@PersistenceConstructor
	public Record(String user, Set<String> wrongOnce, Set<String> wrongTwice) {
		super();
		this.user = user;
		this.wrongOnce = wrongOnce;
		this.wrongTwice = wrongTwice;
	}

	public String getUser() {
		return user;
	}

	public Set<String> getWrongOnce() {
		return wrongOnce;
	}

	public Set<String> getWrongTwice() {
		return wrongTwice;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setWrongOnce(Set<String> wrongOnce) {
		this.wrongOnce = wrongOnce;
	}

	public void setWrongTwice(Set<String> wrongTwice) {
		this.wrongTwice = wrongTwice;
	}

}
