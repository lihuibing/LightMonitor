package org.falcon.system.repositories;

import org.falcon.system.model.RequestTimeLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lihuibing on 2017/6/23.
 */
public interface RequestTimeLogRepository extends MongoRepository<RequestTimeLog,String> {
}
