package org.cweili.drivingtest.domain;

import java.io.InputStream;

/**
 * 图片
 * 
 * @author Cweili
 * @version 2013-3-26 下午8:06:34
 * 
 */
public class Image {

	String name;
	InputStream inputStream;
	byte[] data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
