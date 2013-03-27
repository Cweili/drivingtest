package org.cweili.drivingtest.repository;

import org.cweili.drivingtest.domain.Image;

public interface ImageRespository {

	public <S extends Image> S save(S image);

	public Image findOne(String name);
}
