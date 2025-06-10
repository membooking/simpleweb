package com.enet.io.lppage.webapp.model;

import java.util.List;

/**
 * User: lehungban
 * Date: 9/10/21
 * Time: 8:57 AM
 */
public class Bitem {
    private String path;
    private String label;
    private String cssClass;
    private String type = "div";
    private String href;
    private String description;
    private String iconCss;
    private List<Bitem> items;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Bitem> getItems() {
        return items;
    }

    public void setItems(List<Bitem> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconCss() {
        return iconCss;
    }

    public void setIconCss(String iconCss) {
        this.iconCss = iconCss;
    }
}
