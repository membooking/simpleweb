package com.enet.io.lppage.core.service;


import java.io.Serializable;
import java.util.List;

/**
 *
 */
public interface GenericService<T, ID extends Serializable> {

    @SuppressWarnings("unchecked")
	public Class getPersistentClass();

    public T findById(ID id);

    public T findEqualUnique(String property, Object value);

    public T save(T entity);

    public T update(T entity);

    public T saveOrUpdate(T entity);

    public void delete(T entity);

    public void detach(T entity);

    public List<T> find(int maxResults);

}