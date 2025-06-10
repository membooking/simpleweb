package com.enet.io.lppage.webapp.model;

/**
 * User: lehungban
 * Date: 9/10/21
 * Time: 9:03 AM
 */
public class BitemLogo {
    private String logo;
    private String width;
    private String height = "70px";
    private String href = "/";
    private String align = "left";

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}
