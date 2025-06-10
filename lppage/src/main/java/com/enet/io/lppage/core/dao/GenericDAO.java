package com.enet.io.lppage.core.dao;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
public interface GenericDAO<T, ID extends Serializable> {

	public void setSessionFactory(SessionFactory sessionFactory);
	public SessionFactory getSessionFactory();

    public Class<T> getPersistentClass();

    public T findById(ID id, boolean lock);

    public T findEqualUnique(final String property, final Object value);

	T save(T entity) throws DataAccessException;

	T update(T entity) throws DataAccessException;

    T merge(T entity) throws DataAccessException;

	T saveOrUpdate(T entity) throws DataAccessException;

	void delete(T entity) throws DataAccessException;

    void delete(ID entity) throws DataAccessException;

    void detach(T entity);

    List<T> find(int maxResults);

    public List<T> findProperty(final String property, final Object value);
    public List<?> findProperties(Map<String, Object> propertyNameValues);

	List<T> findProperty(final String property, final Object value, int maxResults);
}