package com.parseme;

import com.magazine.Document;

// XML parser - I think...
public class Main {

    public static void main(String[] args) {
        Document doc = new Document();
        doc.setFileName("test.xml");

        new XMLTreeParsing(doc);

    }
}
