package com.magazine;

/**
 * Created by Leszcz on 5/7/2016.
 */
public enum Specials {
    HEADER_START("<?xml "),
    HEADER_END("?>"),
    COMMENT_START("<!-- "),
    COMMENT_END(" -->"),
    STYLESHEET("<?xml-stylesheet "),
    ELEMENT_BEGIN("<"),
    ELEMENT_END("</"),
    NODE_ONELINE("/>"),
    NODE_END(">"),
    SPACE(" ");


    private String description;
    Specials(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}

