package org.falcon.light.repositories;

import org.falcon.light.model.LightOperationLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lihuibing on 2017/6/20.
 */
public interface LightOperationLogRepository extends MongoRepository<LightOperationLog,String> {
}
