package org.falcon.light.service;

import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightMainControl;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by lihuibing on 2017/6/19.
 */
public interface ILightInfoService {
    void addLightInfo(LightInfo lightInfo);
    Page<LightInfo> findAll(LightMainControl mainControl, int page, int size);
    LightInfo getById(String id);
    List<LightInfo> findByShortIp(String shortIp);
}
