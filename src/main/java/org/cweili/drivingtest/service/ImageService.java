package org.cweili.drivingtest.service;

import org.cweili.drivingtest.domain.Image;
import org.cweili.drivingtest.repository.ImageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

@Service("imageService")
@Scope("prototype")
public class ImageService {

	@Autowired
	ImageRespository imageRespository;

	public String getImage(String name) {
		Image image = imageRespository.findOne(name);
		if (null != image) {
			return new BASE64Encoder().encode(image.getData());
		}
		return "";
	}
}
