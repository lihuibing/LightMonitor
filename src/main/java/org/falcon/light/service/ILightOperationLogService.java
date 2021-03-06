package org.falcon.light.service;

import org.falcon.framework.service.ICommonService;
import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightOperationLog;

/**
 * Created by lihuibing on 2017/6/20.
 */
public interface ILightOperationLogService extends ICommonService<LightOperationLog,String> {
    void addLightOperationLog(String messageStr, LightInfo lightInfo);
}
