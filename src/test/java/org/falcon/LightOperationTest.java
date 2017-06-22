package org.falcon;

import org.falcon.light.constants.LightOperationConstants;
import org.falcon.light.model.LightOperationLog;
import org.falcon.light.service.ILightOperationLogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        lightOperationLog.setType(LightOperationConstants.LIGHT_OPERATION_RECEIVED);
        lightOperationLogService.save(lightOperationLog);
    }

    @Test
    public void findAll(){
        List<LightOperationLog> logs =  lightOperationLogService.findAll();
        logs.forEach(log -> {
            System.out.println(log.getCreateDate());
        });
    }

    @Test
    public void findOne(){
        LightOperationLog log = lightOperationLogService.findById("e00c0ef0-165f-4b71-a481-3c820d99b8a6");
        Assert.assertEquals(log.getType(),2);
    }

}
