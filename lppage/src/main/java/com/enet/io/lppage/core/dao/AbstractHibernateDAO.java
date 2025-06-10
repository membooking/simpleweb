package com.enet.io.lppage.core.dao;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public abstract class AbstractHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	private SessionFactory sessionFactory;

	public AbstractHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

    /**
     *
     * @return
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    /**
     *
     * @param persistentClass
     */
    protected AbstractHibernateDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
     /**
     * @param id
     * @param lock
     * @return
     */
    @SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
        T entity = null;
        if (lock) {
            entity = (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id,
                    LockMode.UPGRADE_NOWAIT);
        } else {
            entity = (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id);
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    public T findEqualUnique(final String property, final Object value) {
		Query query = sessionFactory.getCurrentSession().createQuery("from " + persistentClass.getName() + " WHERE " + property + " = :value");
		query.setParameter("value",value);
		List<T> list = query.list();
		if (list != null && list.size() == 1) {
			return (T)list.get(0);
		}
		return null;
    }


    /**
     *
     */
    public void delete(T entity) throws DataAccessException {
		sessionFactory.getCurrentSession().delete(entity);

    }

    public void delete(ID id) throws DataAccessException {
        T entity = findById(id, true);
        sessionFactory.getCurrentSession().delete(entity);
    }

    /**
     *
     */
    public T save(T entity) throws DataAccessException  {
		sessionFactory.getCurrentSession().persist(entity);
		return entity;
    }

    /**
     *
     */
    public T saveOrUpdate(T entity) throws DataAccessException {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(entity);
        return entity;
    }

    public T merge(T entity) throws DataAccessException {
        sessionFactory.getCurrentSession().merge(entity);
        return entity;
    }

    /**
     *
     */
    public T update(T entity) throws DataAccessException {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }


    public void detach(final T entity) {
		sessionFactory.getCurrentSession().evict(entity);
	}

    /**
      * return list of row based on maxResults
      */
     @SuppressWarnings("unchecked")
     public List<T> find(final int maxResults) {
		 Query query = sessionFactory.getCurrentSession().createQuery("from " + persistentClass.getName());
		 query.setFirstResult(0);
		 query.setMaxResults(maxResults);
		 return query.list();
     }

    @Override
	public List<T> findProperty(final String property, final Object value) {
		Query query = sessionFactory.getCurrentSession().createQuery("from " + persistentClass.getName() + " WHERE " + property + "= :value");
		query.setParameter("value", value);
		return query.list();
	}

        @Override
        public List<T> findProperties(final Map<String, Object> propertyNameValues) {
			StringBuilder sb = new StringBuilder();
			sb.append(" FROM " + persistentClass.getName() + " t WHERE 1 = 1 ");
			for (String name : propertyNameValues.keySet()) {
				if(propertyNameValues.get(name) != null){
					sb.append(String.format(" AND (t.%s is not null AND t.%s =:%s)", name, name, name.replace(".", "_")));
				} else {
					sb.append(String.format(" AND (%s)", name));
				}
			}
			Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
			for (String name : propertyNameValues.keySet()) {
				if(propertyNameValues.get(name) != null){
					query.setParameter(name.replace(".", "_"), propertyNameValues.get(name));
				}
			}
			return query.list();
        }


	@Override
	public List<T> findProperty(final String property, final Object value, final int maxResults) {
		Query query = sessionFactory.getCurrentSession().createQuery("from " + persistentClass.getName() + " WHERE " + property + " = :value");
		query.setParameter("value", value);
		query.setFirstResult(0);
		query.setMaxResults(maxResults);
		return query.list();
	}

	protected T getFirstOrNull(List<T> items){
		if(items != null && items.size() > 0){
			return items.get(0);
		}

		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
