package com.magazine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leszcz on 5/4/2016.
 */
public class Node extends Element implements IElement {


    public Node(){
        nodeList = new ArrayList<>();
        attributeList = new ArrayList<>();
    }


    public Node(int level){
        setLevel(level);
        nodeList = new ArrayList<>();
        attributeList = new ArrayList<>();
    }




    private int lineNumber;
    private List<Attribute> attributeList;
    private List<Node> nodeList;

    public int getLevel() {
        return lineNumber;
    }

    public void setLevel(int level) {
        this.lineNumber = level;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }


    @Override
    public Node getParentNode() {
        if (this.getLevel()==0)
            return null;
        else{
            return new Node();
        }
    }

    @Override
    public Node getChildNode() {
        return null;
    }

    @Override
    public boolean hasChild() {
        if (isDocHeader())
            return false;
        else
            return true;
    }

    @Override
    public boolean hasAttributes() {
        return false;
    }

    @Override
    public boolean isDocHeader() {
        return false;
    }


}
