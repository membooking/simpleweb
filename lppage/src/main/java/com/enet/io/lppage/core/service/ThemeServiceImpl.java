package com.enet.io.lppage.core.service;
import com.enet.io.lppage.core.dao.GenericDAO;
import com.enet.io.lppage.core.dao.ThemeComponentDAO;
import com.enet.io.lppage.core.domain.ThemeComponent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class ThemeServiceImpl extends GenericServiceImpl<ThemeComponent,Long>
                                                    implements ThemeService {

    protected final Log logger = LogFactory.getLog(getClass());

    private ThemeComponentDAO themeComponentDAO;

    @Override
	protected GenericDAO<ThemeComponent, Long> getGenericDAO() {
		return themeComponentDAO;
	}

    @Override
    public ThemeComponent saveThemeComponent(ThemeComponent themeComponent) {
        return themeComponentDAO.saveOrUpdate(themeComponent);
    }

    @Override
    public List<ThemeComponent> findComponents(String theme, String comcode, String section, String tag, int max) {
        return themeComponentDAO.find(theme,comcode,section,tag,max);
    }

    @Override
    public ThemeComponent findComponentById(Long themeComponentId) {
        return themeComponentDAO.findById(themeComponentId,false);
    }

    @Override
    public ThemeComponent findComponentByCode(String theme, String comcode) {
        List<ThemeComponent> list = findComponents(theme,comcode,null,null,1);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ThemeComponent> findPageComponents(String theme, String tag) {
        List<ThemeComponent> list = findComponents(theme,null,null,tag,50);
        return list;
    }

    public void setThemeComponentDAO(ThemeComponentDAO themeComponentDAO) {
        this.themeComponentDAO = themeComponentDAO;
    }
}