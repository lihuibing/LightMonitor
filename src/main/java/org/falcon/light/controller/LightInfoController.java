package org.falcon.light.controller;

import org.falcon.mina.ServerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihuibing on 2017/6/19.
 */
@RestController
public class LightInfoController {

   @RequestMapping("/test")
   public String test(@RequestParam String name){
       System.out.println(name);
       try {
           Thread.sleep(100);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return "hello";
   }




}
