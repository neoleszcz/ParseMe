package com.magazine;

/**
 * Created by Leszcz on 5/4/2016.
 */
public interface IElement {

    Node getParentNode();
    Node getChildNode();
    boolean hasChild();
    boolean hasAttributes();
    boolean isDocHeader();

}
