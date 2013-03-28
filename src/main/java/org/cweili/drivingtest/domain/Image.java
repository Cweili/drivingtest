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
	byte[] data;

	public Image() {
		super();
	}

	public Image(String name, byte[] data) {
		super();
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
