package org.cweili.drivingtest.repository;

import org.cweili.drivingtest.domain.Image;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 图片 Repository
 * 
 * @author Cweili
 * @version 2013-4-12 上午10:35:55
 * 
 */
@NoRepositoryBean
public interface ImageRespository extends PagingAndSortingRepository<Image, String> {

}
