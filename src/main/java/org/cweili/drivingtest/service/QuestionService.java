/**
 * 
 */
package org.cweili.drivingtest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.cweili.drivingtest.domain.Image;
import org.cweili.drivingtest.domain.Question;
import org.cweili.drivingtest.repository.ImageRespository;
import org.cweili.drivingtest.repository.QuestionRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

	@Autowired
	ImageRespository imageRespository;

	/**
	 * 获取图片
	 * 
	 * @param name
	 * @return
	 */
	public String getImage(String name) {
		Image image = imageRespository.findOne(name);
		if (null != image) {
			return Base64.encodeBase64String(image.getData());
		}
		return "";
	}

	/**
	 * 获取问题
	 * 
	 * @param id
	 * @return
	 */
	public String getQuestion(String id) {
		Question question = questionRepository.findOne(id);
		if (null == question) {
			question = new Question("", (byte) 0, "", null, (byte) 0, "", "");
		}
		return new JSONObject(question).toString();
	}

	/**
	 * 获取问题id列表
	 * 
	 * @param order
	 * @return
	 */
	public String getQuestionIdList(String order) {
		List<String> idList;
		if (null != order && "#random".equals(order)) {
			idList = getIdList(new LinkedList<String>());
			Collections.shuffle(idList);
		} else {
			idList = getIdList(new ArrayList<String>());
		}
		return JSONObject.valueToString(idList);
	}

	private List<String> getIdList(List<String> idList) {
		for (Question question : questionRepository.findAll()) {
			idList.add(question.getId());
		}
		return idList;
	}
}
