package org.falcon.light.model;

import lombok.Data;
<<<<<<< HEAD
import org.falcon.framework.model.BaseEntity;
=======
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lihuibing on 2017/6/20.
 */
@Data
@Document(collection = "LightOperationLog")
<<<<<<< HEAD
public class LightOperationLog extends BaseEntity {
=======
public class LightOperationLog {

    @Id
    private String id;
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f

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
