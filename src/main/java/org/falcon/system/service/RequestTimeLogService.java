package org.falcon.system.service;

import org.falcon.system.model.RequestTimeLog;
import org.falcon.system.repositories.RequestTimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lihuibing on 2017/6/23.
 */
@Service
public class RequestTimeLogService {

    @Autowired
    private RequestTimeLogRepository requestTimeLogRepository;

    public void addRequestTimeLog(RequestTimeLog requestTimeLog){
        requestTimeLogRepository.save(requestTimeLog);
    }

}
