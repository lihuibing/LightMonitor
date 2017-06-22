package org.falcon.light.model;

import lombok.Data;
import org.falcon.framework.model.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lihuibing on 2017/6/8.
 */
@Data
@Document(collection = "LightMainControl")
public class LightMainControl extends BaseEntity {

    /**
     * mac地址
     */
    private String mac;

    /**
     * 网管控制街道
     */
    private String location;

    /**
     * 控制器类型
     */
    private String type;

}
