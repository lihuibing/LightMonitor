package org.falcon.light.model;

import lombok.Data;
import org.falcon.framework.model.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lihuibing on 2017/6/8.
 */
@Data
@Document(collection = "LightInfo")
public class LightInfo extends BaseEntity {

    /**
     * 路灯坐标
     */
    private LightPoint lightPoint;

    /**
     * 类型
     */
    private String type;

    /**
     * 短地址
     */
    private String shortIp;

    /**
     * 对应主控信息
     */
    private LightMainControl lightMainControl;
    /**
     * 路灯状态
     */
    private int status;

}
