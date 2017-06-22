package org.falcon.framework.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.falcon.framework.utils.DateUtils;
import org.falcon.system.model.RequestTimeLog;
import org.falcon.system.service.RequestTimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Created by lihuibing on 2017/6/23.
 */
@Aspect
@Component
public class RequestTimeMonitor {

    @Autowired
    private RequestTimeLogService requestTimeLogService;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void userRequest(){}

    @Around("userRequest()")
    public Object doAfterReturning(ProceedingJoinPoint  point) throws Throwable {
        RequestTimeLog log = new RequestTimeLog();
        Class clazz = point.getSignature().getDeclaringType();
        String methodName = point.getSignature().getName();
        Object[] fieldValues = point.getArgs();
        log.setParams(fieldValues);
        log.setMethodName(methodName);
        log.setClazz(clazz.getName());
        long a = System.currentTimeMillis();
        String beginTime = DateUtils.getCurrentDateTime();
        Object object = point.proceed();
        long b = System.currentTimeMillis();
        String endTime = DateUtils.getCurrentDateTime();
        log.setStartTime(beginTime);
        log.setEndTime(endTime);
        log.setHandleTime(b-a);
        log.setResult(object);
        log.setId(UUID.randomUUID().toString());
        requestTimeLogService.addRequestTimeLog(log);
        return object;
    }


}
