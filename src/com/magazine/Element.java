package com.magazine;

/**
 * Created by Leszcz on 5/4/2016.
 */
public abstract class Element {
    private String name;
    private String value;
    private boolean hasChild = true;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;

    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }



}
