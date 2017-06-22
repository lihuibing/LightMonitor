package org.falcon.light.service;

import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightOperationLog;

/**
 * Created by lihuibing on 2017/6/20.
 */
public interface ILightOperationLogService {
    void save(LightOperationLog lightOperationLog);
    void addLightOperationLog(String messageStr, LightInfo lightInfo);
}
