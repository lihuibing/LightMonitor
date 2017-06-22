package org.falcon.light.repositories;

import org.falcon.light.model.LightMainControl;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lihuibing on 2017/6/8.
 */
public interface LightMainControlRepository extends MongoRepository<LightMainControl,String> {
}
