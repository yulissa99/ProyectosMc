package com.uca.apps.isi.nct.models;

/**
 * Created by moisolutions on 13/10/17.
 */

public class Category {
    private String name;
    private String icon;
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
