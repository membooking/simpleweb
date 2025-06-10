package com.enet.io.lppage.core.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ban on 06/02/2025.
 */
public class ThemeComponent implements Serializable {
    private Long themecomponentid;
    private String theme;
    private String code;
    private String section;
    private String tags;
    private String content;
    private Integer status;
    private Timestamp lastupdate;
    private String jdata;

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

    public Timestamp getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Timestamp lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getJdata() {
        return jdata;
    }

    public void setJdata(String jdata) {
        this.jdata = jdata;
    }
}
