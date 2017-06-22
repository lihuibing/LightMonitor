package org.falcon.light.model;

import lombok.Data;
import org.falcon.framework.model.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lihuibing on 2017/6/20.
 */
@Data
@Document(collection = "LightOperationLog")
public class LightOperationLog extends BaseEntity {

    /**
     * 指令内容
     */
    private String message;

    /**
     * 操作时间
     */
    private String insertTime;

    /**
     * 路灯信息
     */
    private LightInfo lightInfo;

    /**
     * 指令类型
     */
    private int type;


}
