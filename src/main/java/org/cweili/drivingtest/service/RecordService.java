/**
 * 
 */
package org.cweili.drivingtest.service;

import java.util.HashSet;

import org.cweili.drivingtest.domain.Record;
import org.cweili.drivingtest.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

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
	 * @param id
	 */
	public void addWrongQuestion(String user, String id) {
		Record record = getRecord(user);
		record.getWrongQuestion().add(id);
		recordRepository.save(record);
	}

	/**
	 * 获取错题列表
	 * 
	 * @param user
	 * @return
	 */
	public String getWrongQuestion(String user) {
		return JSON.toJSONString(getRecord(user).getWrongQuestion());
	}

	/**
	 * 删除错题
	 * 
	 * @param user
	 * @param id
	 * @return
	 */
	public String removeWrongQuestion(String user, String id) {
		Record record = getRecord(user);
		record.getWrongQuestion().remove(id);
		recordRepository.save(record);
		return JSON.toJSONString(record.getWrongQuestion());
	}

	private Record getRecord(String user) {
		Record record = recordRepository.findOne(user);
		if (null == record) {
			record = new Record(user, new HashSet<String>());
		}
		return record;
	}
}
