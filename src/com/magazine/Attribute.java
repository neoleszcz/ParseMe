package com.magazine;

import org.w3c.dom.Attr;

/**
 * Created by Leszcz on 5/4/2016.
 */
public class Attribute extends Element {

    public Attribute(){
    }
    public Attribute(String name, String value){
        setName(name);
        setValue(value);
    }
}
