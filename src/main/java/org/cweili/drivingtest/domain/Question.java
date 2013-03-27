package org.cweili.drivingtest.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "question")
public class Question {

	@Id
	private String id;
	private String content;
	private String image;
	private List<String> option;
	private byte answer;
	private String category;
	private String frequency;

	public Question() {
		super();
	}

	@PersistenceConstructor
	public Question(String id, String content, String image, List<String> option, byte answer,
			String category, String frequency) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.option = option;
		this.answer = answer;
		this.category = category;
		this.frequency = frequency;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public byte getAnswer() {
		return answer;
	}

	public void setAnswer(byte answer) {
		this.answer = answer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

}
