package com.enet.io.lppage.core.service;

import com.enet.io.lppage.core.dao.GenericDAO;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ban
 *
 * @param <T>
 * @param <ID>
 */
@Transactional
public abstract class GenericServiceImpl<T, ID extends Serializable>
        implements GenericService<T, ID> {

    protected abstract GenericDAO<T, ID> getGenericDAO();

    @SuppressWarnings("unchecked")
	public Class getPersistentClass() {
        return getGenericDAO().getPersistentClass();
    }

    @Transactional
    public T findById(ID id) {
        T res =  getGenericDAO().findById(id, false);
        return res;
    }
    public T findEqualUnique(String property,
                             Object value) {
        return getGenericDAO().findEqualUnique(property, value);
    }
    public T save(T entity) {
        getGenericDAO().save(entity);
        return entity;
    }

    public T update(T entity) {
        getGenericDAO().update(entity);
        return entity;
    }

    public T saveOrUpdate(T entity) {
        getGenericDAO().saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        this.getGenericDAO().delete(entity);
    }
    public void detach(T entity) {
        this.getGenericDAO().detach(entity);
    }

    public List<T> find(int maxResults) {
        return this.getGenericDAO().find(maxResults);
    }

}


