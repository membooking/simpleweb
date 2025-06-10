package com.enet.io.lppage.webapp.model;

import java.util.List;

public class ComponentData {
    private Bmenu menu;
    private List<String> prompts;

    public Bmenu getMenu() {
        return menu;
    }

    public void setMenu(Bmenu menu) {
        this.menu = menu;
    }

    public List<String> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<String> prompts) {
        this.prompts = prompts;
    }
}
