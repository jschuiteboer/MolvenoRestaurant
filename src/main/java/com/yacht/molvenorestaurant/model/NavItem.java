package com.yacht.molvenorestaurant.model;

public class NavItem {
    private String label;
    private String path;

    public NavItem(String label, String path) {
        this.setLabel(label);
        this.setPath(path);
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
