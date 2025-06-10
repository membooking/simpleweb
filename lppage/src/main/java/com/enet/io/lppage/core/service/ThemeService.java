package com.enet.io.lppage.core.service;

import com.enet.io.lppage.core.domain.ThemeComponent;

import java.util.List;


public interface ThemeService extends GenericService<ThemeComponent,Long> {
    public ThemeComponent saveThemeComponent(ThemeComponent themeComponent);
    List<ThemeComponent> findComponents(String theme, String comcode, String section, String tag, int max);

    ThemeComponent findComponentById(Long themeComponentId);

    ThemeComponent findComponentByCode(String theme, String comcode);

    List<ThemeComponent> findPageComponents(String theme, String tag);
}