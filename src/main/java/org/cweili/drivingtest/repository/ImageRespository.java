package org.cweili.drivingtest.repository;

import org.cweili.drivingtest.domain.Image;

/**
 * 
 * @author Cweili
 * @version 2013-3-28 下午2:14:57
 * 
 */
public interface ImageRespository {

	/**
	 * @param image
	 * @return
	 */
	public <S extends Image> S save(S image);

	/**
	 * @param name
	 * @return
	 */
	public Image findOne(String name);
}
