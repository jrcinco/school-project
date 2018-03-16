package com.school.registerdb.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 *
 * Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
 *
 * @author jhonny
 *
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */

public interface GenericDao<T, PK extends Serializable> {
    public T find(PK id);
    public void delete(T obj);
    public void saveOrUpdate(T obj);
    public List<T> getAll();
}