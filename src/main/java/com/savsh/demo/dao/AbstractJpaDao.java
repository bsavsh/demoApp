package com.savsh.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> implements IGenericDao<T>{

    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public AbstractJpaDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(final int id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final int entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}

