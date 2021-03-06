/**
 * 
 */
package org.cweili.drivingtest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.cweili.drivingtest.domain.Image;
import org.cweili.drivingtest.domain.Question;
import org.cweili.drivingtest.repository.ImageRespository;
import org.cweili.drivingtest.repository.QuestionRepository;
import org.cweili.drivingtest.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 导入数据
 * 
 * @author Cweili
 * @version 2013-3-26 上午10:55:51
 * 
 */
@Service("importData")
@Scope("prototype")
public class ImportData {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	ImageRespository imageRespository;

	/**
	 * 导入数据
	 */
	public long importData() {
		if (questionRepository.count() > 0) {
			return 0;
		}
		try {
			BufferedReader bw = new BufferedReader(new FileReader(getRoot() + "questiondb.csv"));
			String line;
			String[] params;
			String id;
			Question question;
			byte type;
			byte answer;
			List<String> option = new ArrayList<String>();
			while ((line = bw.readLine()) != null) {
				option.clear();
				line = StringUtils.replace(line, "\"", "");
				params = StringUtils.commaDelimitedListToStringArray(line);
				id = Util.shortenInt(params[0]);// new ObjectId().toString();
				if ("noimg".equals(params[3])) {
					params[3] = "";
				} else {
					Image image = new Image();
					image.setName(id);
					image.setInputStream(getImage(params[3]));
					imageRespository.save(image);
				}
				option.add(params[4]);
				option.add(params[5]);
				if (!"null".equals(params[6])) {
					option.add(params[6]);
				}
				if (!"null".equals(params[7])) {
					option.add(params[7]);
				}
				type = Byte.parseByte(params[1]);
				answer = Byte.parseByte(params[8]);
				question = new Question(id, type, params[2], option, answer, params[9], params[10]);
				questionRepository.save(question);
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionRepository.count();
	}

	private String getRoot() {
		return this.getClass().getResource("/").getPath().toString();
	}

	private InputStream getImage(String name) throws IOException {
		File file = new File(getRoot() + "image/" + name);
		InputStream iuputStream = new FileInputStream(file);
		return iuputStream;
	}

}
