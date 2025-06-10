package com.enet.io.lppage.webapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lehungban
 * Date: 9/10/21
 * Time: 8:55 AM
 */
public class BmenuTop {
    private Boolean show = true;
    private String cssClass = "navbar-dark bg-dark border-bottom";
    private Bitem titleItem;
    private List<Bitem> leftItems = new ArrayList<>();
    private List<Bitem> rightItems = new ArrayList<>();

    public List<Bitem> getLeftItems() {
        return leftItems;
    }

    public void setLeftItems(List<Bitem> leftItems) {
        this.leftItems = leftItems;
    }

    public List<Bitem> getRightItems() {
        return rightItems;
    }

    public void setRightItems(List<Bitem> rightItems) {
        this.rightItems = rightItems;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public Bitem getTitleItem() {
        return titleItem;
    }

    public void setTitleItem(Bitem titleItem) {
        this.titleItem = titleItem;
    }
}
