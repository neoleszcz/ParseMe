package com.magazine;

import org.w3c.dom.Attr;

import java.util.List;

/**
 * Created by Leszcz on 5/4/2016.
 */
public class DocHeader {
    private List<Attribute> headerAttribs;
    private List<Attribute> styleAttribs;

    public List<Attribute> getHeaderAttribs() {
        return headerAttribs;
    }

    public void setHeaderAttribs(List<Attribute> headerAttribs) {
        this.headerAttribs = headerAttribs;
    }

    public List<Attribute> getStyleAttribs() {
        return styleAttribs;
    }

    public void setStyleAttribs(List<Attribute> styleAttribs) {
        this.styleAttribs = styleAttribs;
    }

    public DocHeader(List<Attribute> headerAttribs, List<Attribute> styleAttribs){
        setHeaderAttribs(headerAttribs);
        setStyleAttribs(styleAttribs);
    }
}
