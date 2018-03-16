package com.school.registerdb.service.impl;

import com.school.registerdb.service.GenericManager;
import com.school.registerdb.dao.GenericDao;
import java.io.Serializable;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use.
 *
 * @author jhonny
 * 
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * 
 */
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
    
    protected GenericDao<T, PK> dao;
    
    public GenericManagerImpl() {
    }
    
    public GenericManagerImpl(GenericDao<T, PK> genericDao) {
        this.dao = genericDao;
    }
    
    @Override
    public T find(PK id) {
        return dao.find(id);
    }

    @Override
    public void delete(T obj) {
        dao.delete(obj);
    }

    @Override
    public void saveOrUpdate(T obj) {
        dao.saveOrUpdate(obj);
    }
}
