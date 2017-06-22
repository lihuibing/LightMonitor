package org.falcon;

import org.falcon.framework.utils.DateUtils;
import org.falcon.light.constants.LightOperationConstants;
import org.falcon.light.model.LightOperationLog;
import org.falcon.light.service.ILightOperationLogService;
import org.falcon.light.service.LightOperationLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by lihuibing on 2017/6/22.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class LightOperationTest {

    @Autowired
    private ILightOperationLogService lightOperationLogService;

    @Test
    public void testSave(){
        LightOperationLog lightOperationLog = new LightOperationLog();
        lightOperationLog.setId(UUID.randomUUID().toString());
        lightOperationLog.setType(LightOperationConstants.LIGHT_OPERATION_RECEIVED);
        lightOperationLog.setInsertTime(DateUtils.getCurrentDateTime());
        lightOperationLogService.save(lightOperationLog);
    }

}
