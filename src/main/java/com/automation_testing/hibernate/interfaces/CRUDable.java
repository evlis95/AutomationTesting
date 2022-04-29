package com.automation_testing.hibernate.interfaces;

import java.util.List;

public interface CRUDable <T> {

    T findById(String id);

    void update(T entity);

    void save(T entity);

    void merge(T entity);

    void saveOrUpdate (T entity);

    void delete(T entity);

    List<T> findAll();
}
