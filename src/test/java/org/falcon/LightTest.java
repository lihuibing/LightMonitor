package org.falcon;

import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lihuibing on 2017/6/8.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class LightTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test(){
        LightInfo lightInfo = new LightInfo();
        lightInfo.setId("test");
        LightPoint lightPoint = new LightPoint();
        lightPoint.setLat("123.3434");
        lightPoint.setLng("232323");
        lightInfo.setLightPoint(lightPoint);
        mongoTemplate.save(lightInfo);
        LightInfo lightInfo2 =  mongoTemplate.findById("test",lightInfo.getClass());
        System.out.println(lightInfo2.getLightPoint().getLat());
//        mongoTemplate.remove(lightInfo);

    }

}
