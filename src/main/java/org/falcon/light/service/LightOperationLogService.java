package org.falcon.light.service;

import org.falcon.light.model.LightOperationLog;
import org.falcon.light.repositories.LightOperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lihuibing on 2017/6/20.
 */
@Service
public class LightOperationLogService implements ILightOperationLogService {

    @Autowired
    private LightOperationLogRepository lightOperationLogRepository;

    @Override
    public void save(LightOperationLog lightOperationLog) {
        lightOperationLogRepository.save(lightOperationLog);
    }
}
