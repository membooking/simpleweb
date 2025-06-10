package com.enet.io.lppage.webapp.model;

import java.io.Serializable;

/**
 * Created by ban on 06/02/2025.
 */
public class ContentComponent implements Serializable {
    private Long themecomponentid;
    private String theme;
    private String code;
    private String section;
    private String tags;
    private String content;
    private Integer status;
    private Long lastupdate;
    private ComponentData data;

    public Long getThemecomponentid() {
        return themecomponentid;
    }

    public void setThemecomponentid(Long themecomponentid) {
        this.themecomponentid = themecomponentid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Long lastupdate) {
        this.lastupdate = lastupdate;
    }

    public ComponentData getData() {
        return data;
    }

    public void setData(ComponentData data) {
        this.data = data;
    }
}
