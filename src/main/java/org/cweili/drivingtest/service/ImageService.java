package org.cweili.drivingtest.service;

import org.apache.commons.codec.binary.Base64;
import org.cweili.drivingtest.domain.Image;
import org.cweili.drivingtest.repository.ImageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Cweili
 * @version 2013-3-28 下午2:16:25
 * 
 */
@Service("imageService")
@Scope("prototype")
public class ImageService {

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
}
