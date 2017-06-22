package org.falcon.light.model;

import lombok.Data;
<<<<<<< HEAD
import org.falcon.framework.model.BaseEntity;
=======
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lihuibing on 2017/6/8.
 */
@Data
@Document(collection = "LightMainControl")
<<<<<<< HEAD
public class LightMainControl extends BaseEntity {
=======
public class LightMainControl {

    @Id
    private String id;
>>>>>>> 11240d4fe4448ed705fdaf116aa387e93b640d4f

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
