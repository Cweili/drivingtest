package org.cweili.drivingtest.repository;

import org.cweili.drivingtest.domain.Question;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 问题 Repository
 * 
 * @author Cweili
 * @version 2013-3-25 下午6:48:47
 * 
 */
public interface QuestionRepository extends PagingAndSortingRepository<Question, String> {

}
