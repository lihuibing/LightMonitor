package org.falcon.light.repositories;

import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightMainControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by lihuibing on 2017/6/8.
 */
public interface LightInfoRepository extends MongoRepository<LightInfo,String> {
    Page<LightInfo> findByLightMainControl(LightMainControl mainControl, Pageable pageable);
    List<LightInfo> findByShortIp(String shortIp);
}
