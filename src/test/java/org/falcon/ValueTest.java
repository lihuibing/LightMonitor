package org.falcon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lihuibing on 2017/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueTest {

    @Value(value = "${server.port}")
    private int port;

    @Test
    public void getValue(){
        System.out.println("the server port is : "+port);
    }

}
