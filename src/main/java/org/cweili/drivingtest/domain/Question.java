package org.cweili.drivingtest.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 问题
 * 
 * @author Cweili
 * @version 2013-3-28 下午12:14:39
 * 
 */
@Document(collection = "question")
public class Question {

	@Id
	private String id;
	private byte type;
	private String content;
	private List<String> option;
	private byte answer;
	private String category;
	private String frequency;

	public Question() {
		super();
	}

	@PersistenceConstructor
	public Question(String id, byte type, String content, List<String> option, byte answer,
			String category, String frequency) {
		super();
		this.id = id;
		this.type = type;
		this.content = content;
		this.option = option;
		this.answer = answer;
		this.category = category;
		this.frequency = frequency;
	}

	public byte getAnswer() {
		return answer;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getId() {
		return id;
	}

	public List<String> getOption() {
		return option;
	}

	public byte getType() {
		return type;
	}

	public void setAnswer(byte answer) {
		this.answer = answer;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public void setType(byte type) {
		this.type = type;
	}

}
