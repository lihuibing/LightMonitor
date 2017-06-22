package org.falcon.light.controller;

import org.falcon.mina.ServerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihuibing on 2017/6/19.
 */
@RestController
public class LightInfoController {

    @Autowired
    ServerHandler serverHandler;


}
