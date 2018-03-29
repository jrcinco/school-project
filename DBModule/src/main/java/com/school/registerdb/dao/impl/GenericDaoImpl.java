package com.school.registerdb.dao.impl;

import com.school.registerdb.dao.GenericDao;
import com.school.registerdb.util.Constants;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDaoImpl<T, PK extends Serializable> 
                                    implements GenericDao<T, PK>{
    private Class<T> type;

    private SessionFactory sessionFactoryRegisterDB;
    @Resource(name = Constants.SESSION_FACTORY)
    public void setSessionFactoryRegisterDB(SessionFactory sessionFactoryRegisterDB) {
        this.sessionFactoryRegisterDB = sessionFactoryRegisterDB;

    }
    protected SessionFactory getSessionFactory() {
        if (sessionFactoryRegisterDB == null)
            throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
        return sessionFactoryRegisterDB;
    }

    public Class<T> getType() {
        return type;
    }

    public GenericDaoImpl(final Class<T> type) {
        this.type = type;
    }

    @Override
    @Transactional(readOnly = true, value = Constants.TRANSACTION_MGR)    
    public T find(PK id) {
        return (T) getSessionFactory().getCurrentSession().get(getType(), id);
    }

    @Override
    @Transactional(value = Constants.TRANSACTION_MGR)    
    public void delete(T obj) {
        getSessionFactory().getCurrentSession().delete(obj);
    }

    @Override
    @Transactional(value = Constants.TRANSACTION_MGR)    
    public void saveOrUpdate(T obj) {
        getSessionFactory().getCurrentSession().saveOrUpdate(obj);
    }
    
    @Override
    @Transactional(value = Constants.TRANSACTION_MGR)    
    public List<T> getAll() {
        Session session = getSessionFactory().getCurrentSession();
        List<T> list = session.createCriteria(getType()).list();
        return list;
    }
}