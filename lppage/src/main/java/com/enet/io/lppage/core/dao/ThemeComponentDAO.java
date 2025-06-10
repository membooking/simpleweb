package com.enet.io.lppage.core.dao;


import com.enet.io.lppage.core.domain.ThemeComponent;

import java.util.List;

public interface ThemeComponentDAO extends GenericDAO<ThemeComponent,Long> {

    List<ThemeComponent> find(String theme, String comcode, String section, String tag, int max);
}