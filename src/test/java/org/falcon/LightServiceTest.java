package org.falcon;

import com.mongodb.util.JSON;
import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightMainControl;
import org.falcon.light.service.LightInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by lihuibing on 2017/6/8.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class LightServiceTest {
    @Autowired
    LightInfoService lightInfoService;

    @Test
    public void testCase(){
        LightInfo lightInfo = new LightInfo();
        LightMainControl lightMainControl = new LightMainControl();
        String uuid = UUID.randomUUID().toString();
        lightInfo.setId(uuid);
        lightMainControl.setId(uuid);
        lightInfo.setLightMainControl(lightMainControl);
        lightInfoService.addLightInfo(lightInfo);
        Page<LightInfo> page = lightInfoService.findAll(lightMainControl,0,10);
        System.out.println(page.getContent().size());
        LightInfo lightInfo1 = lightInfoService.getById(uuid);
        System.out.println(lightInfo1.toString());
    }

}
