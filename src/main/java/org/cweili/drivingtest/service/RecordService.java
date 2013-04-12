/**
 * 
 */
package org.cweili.drivingtest.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

import org.cweili.drivingtest.domain.Record;
import org.cweili.drivingtest.repository.RecordRepository;
import org.cweili.drivingtest.util.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Cweili
 * @version 2013-3-28 下午12:14:27
 * 
 */
@Service("recordService")
@Scope("prototype")
public class RecordService {

	@Autowired
	RecordRepository recordRepository;

	/**
	 * 添加错题
	 * 
	 * @param user
	 *            用户名
	 * @param review
	 *            复习次数
	 * @param id
	 *            错题id
	 */
	public void addWrongQuestion(String user, int review, String id) {
		Record record = getRecord(user);
		if (2 == review) {
			record.getWrongTwice().add(id);
		} else {
			record.getWrongOnce().add(id);
		}
		recordRepository.save(record);
	}

	/**
	 * 获取错题列表
	 * 
	 * @param user
	 *            用户名
	 * @param review
	 *            复习次数
	 * @return JSON
	 */
	public String getWrongQuestion(String user, int review) {
		LinkedList<String> list;
		if (2 == review) {
			list = new LinkedList<String>(getRecord(user).getWrongTwice());
		} else {
			list = new LinkedList<String>(getRecord(user).getWrongOnce());
		}
		Collections.shuffle(list);
		return JSONObject.valueToString(list);
	}

	/**
	 * 删除错题
	 * 
	 * @param user
	 *            用户名
	 * @param review
	 *            复习次数
	 * @param id
	 *            错题id
	 * @return JSON
	 */
	public String removeWrongQuestion(String user, int review, String id) {
		Record record = getRecord(user);
		if (2 == review) {
			record.getWrongTwice().remove(id);
		} else {
			record.getWrongOnce().remove(id);
		}
		recordRepository.save(record);
		return getWrongQuestion(user, review);
	}

	private Record getRecord(String user) {
		user = Util.shortenInt(user);
		Record record = recordRepository.findOne(user);
		if (null == record) {
			record = new Record(user, new HashSet<String>(), new HashSet<String>());
		}
		return record;
	}
}
