package org.falcon.framework.service;

import org.falcon.framework.constants.RecConstants;
import org.falcon.framework.model.BaseEntity;
import org.falcon.framework.utils.DateUtils;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by lihuibing on 2017/6/22.
 */
@NoRepositoryBean
public abstract class CommonService<T extends BaseEntity,ID extends Serializable> implements ICommonService<T,ID> {

    public abstract MongoRepository<T,ID> getMongoRepository();


    @Override
    public void save(T entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setRecStatus(RecConstants.REC_STATUS_VALID);
        getMongoRepository().save(entity);
    }

    @Override
    public List<T> findAll() {
        return getMongoRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return getMongoRepository().findOne(id);
    }

    @Override
    public void update(T entity) {
        entity.setRecStatus(RecConstants.REC_STATUS_UNVALID);
        getMongoRepository().save(entity);
        entity.setId(UUID.randomUUID().toString());
        entity.setRecStatus(RecConstants.REC_STATUS_VALID);
        entity.setCreateDate(DateUtils.getCurrentDateTime());
        getMongoRepository().save(entity);
    }

    @Override
    public void remove(T entity) {

    }


}
