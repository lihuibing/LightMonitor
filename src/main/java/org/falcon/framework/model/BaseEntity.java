package org.falcon.framework.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by lihuibing on 2017/6/22.
 */
@Data
public class BaseEntity {

    @Id
    private String id;

    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 数据状态
     */
    private int recStatus;

    /**
     * 更新时间
     */
    private String updateDate;
}
