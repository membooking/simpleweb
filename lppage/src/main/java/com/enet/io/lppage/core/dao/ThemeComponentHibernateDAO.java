package com.enet.io.lppage.core.dao;

import com.enet.io.lppage.core.domain.ThemeComponent;
import org.hibernate.query.Query;

import java.util.List;

public class ThemeComponentHibernateDAO extends
		AbstractHibernateDAO<ThemeComponent, Long> implements
		ThemeComponentDAO {

    public ThemeComponentHibernateDAO() {
		super(ThemeComponent.class);
	}

	@Override
	public List<ThemeComponent> find(String theme, String code, String section, String tag, int max) {
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT h FROM ThemeComponent h WHERE h.theme = :theme");
		if (code != null) {
			sqlQuery.append(" AND h.code = :code");
		}
		if (section != null) {
			sqlQuery.append(" AND h.section = :section");
		}
		if (tag != null) {
			sqlQuery.append(" AND h.tags like :tag");
		}
		Query query = getSessionFactory().getCurrentSession().createQuery(sqlQuery.toString());
		query.setParameter("theme",theme);
		if (code != null) {
			query.setParameter("code",code);
		}
		if (section != null) {
			query.setParameter("section",section);
		}
		if (tag != null) {
			query.setParameter("tag", "%"+tag+"%");
		}
		query.setFirstResult(0);
		query.setMaxResults(max);
		return query.list();
	}
}
