package com.enet.io.lppage.webapp.model;

/**
 * User: lehungban
 * Date: 9/10/21
 * Time: 8:53 AM
 */
public class Bmenu {
    private BmenuTop bmenuTop;
    private BmenuMain bmenuMain;
    private String cssClass;
    private String bgColor;
    private String bgColorTop;
    private String bgGradientColor;
    private String txtColor;
    private String txtColorTop;
    private String fontFamily;
    private String headerType = "left-right";

    public Bmenu(){}

    public Bmenu(Boolean showtop, String align){
        bmenuTop = new BmenuTop();
        bmenuTop.setShow(showtop);
        bmenuTop.setCssClass("navbar-dark bg-dark border-bottom");
        bmenuMain = new BmenuMain();
        cssClass = "header-transparent";
        bgColor = "#282828";
        bgColorTop = "#282828";
        bgGradientColor = "#282828";
        txtColor = "#ffffff";
        fontFamily = "Roboto";
    }

    public BmenuTop getBmenuTop() {
        return bmenuTop;
    }

    public void setBmenuTop(BmenuTop bmenuTop) {
        this.bmenuTop = bmenuTop;
    }

    public BmenuMain getBmenuMain() {
        return bmenuMain;
    }

    public void setBmenuMain(BmenuMain bmenuMain) {
        this.bmenuMain = bmenuMain;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getBgGradientColor() {
        return bgGradientColor;
    }

    public void setBgGradientColor(String bgGradientColor) {
        this.bgGradientColor = bgGradientColor;
    }

    public String getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(String txtColor) {
        this.txtColor = txtColor;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getHeaderType() {
        return headerType;
    }

    public void setHeaderType(String headerType) {
        this.headerType = headerType;
    }

    public String getTxtColorTop() {
        return txtColorTop;
    }

    public void setTxtColorTop(String txtColorTop) {
        this.txtColorTop = txtColorTop;
    }

    public String getBgColorTop() {
        return bgColorTop;
    }

    public void setBgColorTop(String bgColorTop) {
        this.bgColorTop = bgColorTop;
    }
}
