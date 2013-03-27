/**
 * 
 */
package org.cweili.drivingtest.domain;

/**
 * 
 * @author Cweili
 * @version 2013-3-26 下午8:06:34
 * 
 */
public class Image {

	String name;
	int length;
	byte[] data;

	public Image() {
		super();
	}

	public Image(String name, int length, byte[] data) {
		super();
		this.name = name;
		this.length = length;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
