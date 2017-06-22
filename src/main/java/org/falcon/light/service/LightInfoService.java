package org.falcon.light.service;

import javafx.scene.effect.Light;
import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightMainControl;
import org.falcon.light.repositories.LightInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lihuibing on 2017/6/8.
 */
@Service
public class LightInfoService implements ILightInfoService {
    @Autowired
    private LightInfoRepository lightInfoRepository;
<<<<<<< HEAD
=======



>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
    /**
     * 保存路灯信息
     * @param lightInfo {@link LightInfo}
     */
    @Override
    public void addLightInfo(LightInfo lightInfo) {
        lightInfoRepository.save(lightInfo);
    }

    /**
     * 分页信息
     * @param page 页码
     * @param size 每页大小
     * @return
     */
    @Override
    public Page<LightInfo> findAll(LightMainControl mainControl, int page, int size){
        Pageable pageable = new PageRequest(page,size);
        Page<LightInfo> lightPage = lightInfoRepository.findByLightMainControl(mainControl,pageable);
        return lightPage;
    }

    /**
     * 根据Id查询路灯信息
     * @param id
     * @return {@link LightInfo}
     */
    @Override
    public LightInfo getById(String id){
        LightInfo lightInfo = lightInfoRepository.findOne(id);
        return lightInfo;
    }

    /**
     * 根据路灯短地址获取路灯信息
     * @param shortIp 路灯短地址
     * @return  {@link LightInfo}
     */
    @Override
    public List<LightInfo> findByShortIp(String shortIp) {
        return lightInfoRepository.findByShortIp(shortIp);
    }

}
