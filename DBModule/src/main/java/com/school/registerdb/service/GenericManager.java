
package com.school.registerdb.service;

import java.io.Serializable;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 *  
 * @author jhonny
 *  
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public interface GenericManager<T, PK extends Serializable> {
    public T find(PK id);
    public void delete(T obj);
    public void saveOrUpdate(T obj);
}
