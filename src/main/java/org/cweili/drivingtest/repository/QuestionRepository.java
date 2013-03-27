/**
 * 
 */
package org.cweili.drivingtest.repository;

import org.cweili.drivingtest.domain.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author Cweili
 * @version 2013-3-25 下午6:48:47
 * 
 */
public interface QuestionRepository extends MongoRepository<Question, String> {

}
