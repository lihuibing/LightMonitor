package org.falcon.system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by lihuibing on 2017/6/23.
 */
@Document(collection = "RequestTimeLog")
@Data
public class RequestTimeLog {

    @Id
    private String id;

    /**
     * 类型
     */
    private String clazz;

    /**
     * 处理时间
     */
    private long handleTime;

    /**
     * 参数
     */
    private Object params;

    /**
     * 访问时间
     */
    private String startTime;

    /**
     * 访问结束时间
     */
    private String endTime;

    /**
     * 结果
     */
    private Object result;

    /**
     * 方法名称
     */
    private String methodName;

}
