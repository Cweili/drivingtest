/**
 * 
 */
package org.cweili.drivingtest.service;

import java.util.ArrayList;
import java.util.List;

import org.cweili.drivingtest.domain.Question;
import org.cweili.drivingtest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Cweili
 * @version 2013-3-25 下午5:20:22
 * 
 */
@Service("questionService")
@Scope("prototype")
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public String test(String test) {
		return "hello" + test;
	}

	public String getQuestion(String id) {
		Question question = questionRepository.findOne(id);
		if (null == question) {
			question = new Question("", "", "", null, (byte) 0, "", "");
		}
		return JSON.toJSONString(question);
	}

	public String getQuestionIdList(String method) {
		List<String> idList = new ArrayList<String>();
		for (Question question : questionRepository.findAll()) {
			idList.add(question.getId());
		}
		if (null != method && "#random".equals(method)) {
			java.util.Collections.shuffle(idList);
		}
		return JSON.toJSONString(idList);
	}
}
