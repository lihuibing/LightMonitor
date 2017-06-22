package org.falcon.light.service;

<<<<<<< HEAD
import org.falcon.framework.service.ICommonService;
import org.falcon.light.model.LightInfo;
=======
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
import org.falcon.light.model.LightOperationLog;

/**
 * Created by lihuibing on 2017/6/20.
 */
<<<<<<< HEAD
public interface ILightOperationLogService extends ICommonService<LightOperationLog,String> {
    void save(LightOperationLog lightOperationLog);
    void addLightOperationLog(String messageStr, LightInfo lightInfo);
=======
public interface ILightOperationLogService {
    void save(LightOperationLog lightOperationLog);
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
}
