package com.magazine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leszcz on 5/7/2016.
 */
public class Document {
    private DocHeader docHeader;
    private Node root;
    private String fileName;



    public Document(){

    }

    public Document(String fileName){
        super();
        setFileName(fileName);
    }




    public DocHeader getDocHeader() {
        return docHeader;
    }

    public void setDocHeader(DocHeader docHeader) {
        this.docHeader = docHeader;
    }

    public Element getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
