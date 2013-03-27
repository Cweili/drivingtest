/**
 * 
 */
package org.cweili.drivingtest.importdata;

import org.cweili.drivingtest.domain.Question;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Cweili
 * @version 2013-3-27 下午7:08:30
 * 
 */
public class TestJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println(JSON.toJSONString(new Question("1", "2", "3", null, (byte) 0, "4", "5")));

	}

}
