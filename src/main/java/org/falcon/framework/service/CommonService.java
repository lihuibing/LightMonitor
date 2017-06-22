package org.falcon.framework.service;

import org.falcon.framework.constants.RecConstants;
import org.falcon.framework.model.BaseEntity;
import org.falcon.framework.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

/**
 * Created by lihuibing on 2017/6/22.
 */
@NoRepositoryBean
public abstract class CommonService<T extends BaseEntity,ID extends Serializable> implements ICommonService<T,ID> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public abstract MongoRepository<T,ID> getMongoRepository();

    private Class<T> getEntityClass(){
        Class < T >  entityClass  =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return entityClass;
    }


    @Override
    public void save(T entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setRecStatus(RecConstants.REC_STATUS_VALID);
        entity.setCreateDate(DateUtils.getCurrentDateTime());
        getMongoRepository().save(entity);
    }

    @Override
    public List<T> findAll() {
        Query query = new Query(Criteria.where("recStatus").is(RecConstants.REC_STATUS_VALID));
        List<T> list = mongoTemplate.find(query,getEntityClass());
        return list;
    }

    @Override
    public T findById(ID id) {
        Query query = new Query(Criteria.where("recStatus").is(RecConstants.REC_STATUS_VALID).and("id").is(id));
        T t = mongoTemplate.findOne(query,getEntityClass());
        return t;
    }

    @Override
    public void update(T entity) {
        entity.setUpdateDate(DateUtils.getCurrentDateTime());
        entity.setRecStatus(RecConstants.REC_STATUS_UNVALID);
        getMongoRepository().save(entity);
        entity.setId(UUID.randomUUID().toString());
        entity.setRecStatus(RecConstants.REC_STATUS_VALID);
        entity.setCreateDate(DateUtils.getCurrentDateTime());
        getMongoRepository().save(entity);
    }

    @Override
    public void remove(T entity) {
        entity.setRecStatus(RecConstants.REC_STATUS_UNVALID);
        getMongoRepository().save(entity);
    }


}
