package org.falcon.light.service;

<<<<<<< HEAD
import org.falcon.framework.service.CommonService;
import org.falcon.light.constants.LightOperationConstants;
import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightOperationLog;
import org.falcon.light.repositories.LightOperationLogRepository;
import org.falcon.framework.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

=======
import org.falcon.light.model.LightOperationLog;
import org.falcon.light.repositories.LightOperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
/**
 * Created by lihuibing on 2017/6/20.
 */
@Service
<<<<<<< HEAD
public class LightOperationLogService extends CommonService<LightOperationLog,String> implements ILightOperationLogService {
=======
public class LightOperationLogService implements ILightOperationLogService {
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f

    @Autowired
    private LightOperationLogRepository lightOperationLogRepository;

<<<<<<< HEAD

    @Override
    public MongoRepository<LightOperationLog, String> getMongoRepository() {
        return lightOperationLogRepository;
    }

    /**
     * 保存日志
     * @param messageStr 消息内容
     * @param lightInfo 路灯信息
     */
    @Override
    public void addLightOperationLog(String messageStr, LightInfo lightInfo) {
        LightOperationLog lightOperationLog = new LightOperationLog();
        lightOperationLog.setMessage(messageStr);
        lightOperationLog.setId(UUID.randomUUID().toString());
        lightOperationLog.setLightInfo(lightInfo);
        lightOperationLog.setType(LightOperationConstants.LIGHT_OPERATION_RECEIVED);
        lightOperationLog.setInsertTime(DateUtils.getCurrentDateTime());
        save(lightOperationLog);
    }

=======
    @Override
    public void save(LightOperationLog lightOperationLog) {
        lightOperationLogRepository.save(lightOperationLog);
    }
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
}
