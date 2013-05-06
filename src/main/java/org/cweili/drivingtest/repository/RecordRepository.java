package org.cweili.drivingtest.repository;

import org.cweili.drivingtest.domain.Record;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 记录 Repository
 * 
 * @author Cweili
 * @version 2013-3-28 下午12:11:14
 * 
 */
public interface RecordRepository extends PagingAndSortingRepository<Record, String> {

}
