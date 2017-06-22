package org.falcon.framework.service;

import org.falcon.framework.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lihuibing on 2017/6/22.
 */
public interface ICommonService<T extends BaseEntity,ID extends Serializable> {
    public void save(T entity);
    public List<T> findAll();
    T findById(ID id);
    void update(T entity);
    void remove(T entity);
}
