package com.savsh.demo.dao;

import java.util.List;

public interface IGenericDao<T> {

    T findOne(final int id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);
}
