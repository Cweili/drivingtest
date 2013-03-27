/**
 * 
 */
package org.cweili.drivingtest.importdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.cweili.drivingtest.domain.Image;
import org.cweili.drivingtest.domain.Question;
import org.cweili.drivingtest.repository.ImageRespository;
import org.cweili.drivingtest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Cweili
 * @version 2013-3-26 上午10:55:51
 * 
 */
@Service("importData")
public class ImportData {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	ImageRespository imageRespository;

	public void importdata() {
		try {
			BufferedReader bw = new BufferedReader(new FileReader(this.getClass().getResource("/")
					.toString().substring(6)
					+ "questiondb.csv"));
			String line;
			String[] params;
			Question question;
			byte answer;
			List<String> option = new ArrayList<String>();
			while ((line = bw.readLine()) != null) {
				option.clear();
				params = line.replace("\"", "").split(",");
				if ("noimg".equals(params[3])) {
					params[3] = "";
				} else {
					File file = new File(this.getClass().getResource("/").toString().substring(6)
							+ "image/" + params[3] + ".jpg");
					byte[] data = new byte[(int) file.length()];
					new FileInputStream(new File(this.getClass().getResource("/").toString()
							.substring(6)
							+ "image/" + params[3] + ".jpg")).read(data);

					imageRespository.save(new Image(params[3], (int) file.length(), data));
				}
				option.add(params[4]);
				option.add(params[5]);
				if (!"null".equals(params[6])) {
					option.add(params[6]);
				}
				if (!"null".equals(params[7])) {
					option.add(params[7]);
				}
				answer = Byte.parseByte(params[8]);
				question = new Question(new ObjectId().toString(), params[2], params[3], option,
						answer, params[9], params[10]);
				questionRepository.save(question);
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}