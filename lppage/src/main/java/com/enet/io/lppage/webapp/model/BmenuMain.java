package com.enet.io.lppage.webapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lehungban
 * Date: 9/10/21
 * Time: 8:55 AM
 */
public class BmenuMain {
    private List<Bitem> leftItems = new ArrayList<>();
    private List<Bitem> rightItems = new ArrayList<>();
    private BitemLogo logo = new BitemLogo();
    private String cssClass = "navbar-transparent navbar-dark bg-dark";

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

    public BitemLogo getLogo() {
        return logo;
    }

    public void setLogo(BitemLogo logo) {
        this.logo = logo;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
}
