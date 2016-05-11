package com.parseme;

import com.magazine.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leszcz on 5/7/2016.
 */



public  class XMLTreeParsing {

    static BufferedReader reader = null;
    List<Node> allNodes = new ArrayList<>();
    static Node root = new Node();

    public XMLTreeParsing(Document document) {


        try {
            allNodes.add(root);
            reader = new BufferedReader(new FileReader(document.getFileName()));
            document.setDocHeader(new DocHeader(
                    getDocHeaderParams(document, Specials.HEADER_START.getDescription().length(), Specials.HEADER_END.getDescription().length()),
                    getDocHeaderParams(document, Specials.STYLESHEET.getDescription().length(), Specials.HEADER_END.getDescription().length())
            ));
            String tmp = (reader.readLine()).trim();
            nodeData(root, tmp);
            //root.setName(nodeName(tmp));
            //root.setAttributeList(getAttribList(tmp));
            if (root.isHasChild())
                getNodesTree(root);

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    public void XMLFileClose() {

        try {
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }


    public static void getNodesTree(Node root) {
        String tmp;

        // boolean inComment = false;

        try {
            while ((tmp = reader.readLine()) != null && !tmp.contains(Specials.ELEMENT_END.getDescription() + root.getName())) {
                System.out.println(tmp);
                tmp = tmp.trim();
                Node child = new Node();
                nodeData(child, tmp);
                root.getNodeList().add(child);

                if (child.isHasChild())
                    getNodesTree(child);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String nodeName(String line) {
        if (!line.contains(" "))
            if (line.endsWith(Specials.NODE_ONELINE.getDescription()))
                return line.substring(1, line.indexOf(Specials.NODE_ONELINE.getDescription()));
            else
                return line.substring(1, line.indexOf(Specials.NODE_END.getDescription()));
        return line.substring(1, line.indexOf(Specials.SPACE.getDescription()));
    }

    public static String nodeValue(String line) {
        return line.substring(line.indexOf(">") + 1, line.indexOf("</"));
    }


    public List<Attribute> getDocHeaderParams(Document document, int startShift, int endShift) {
        String tmp = null;
        try {
            tmp = subAndTrim(
                    startShift,
                    endShift,
                    reader.readLine()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return getAttribList(tmp);
    }


    private static List<Attribute> getAttribList(String line) {

        List<Attribute> attribList = new ArrayList<>();
        String[] strings = line.split("=\"");
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].split(Specials.SPACE.getDescription()).length > 1)
                attribList.add(new Attribute(
                        strings[i].split(Specials.SPACE.getDescription())[strings[i].split(" ").length - 1],
                        ((strings[i + 1].split("\""))[0]).trim()
                ));
            else
                attribList.add(new Attribute(
                        strings[i].split("\"")[strings[i].split("\"").length - 1],
                        ((strings[i + 1].split("\""))[0]).trim()
                ));
            //System.out.println(strings[i].split("\" ")[strings[i].split("\" ").length-1] + "   =   " + (strings[i + 1].split("\" "))[0]);
        }
        return attribList;
    }

    private static String subAndTrim(int subStart, int subEnd, String line) {
        return (line.substring(subStart, line.length() - subEnd));
    }

    public static void nodeData(Node node, String tmp) {

        node.setName(nodeName(tmp));
        node.setAttributeList(getAttribList(tmp));
        if (tmp.endsWith(Specials.NODE_ONELINE.getDescription())) {
            node.setHasChild(false);
        }
        if (tmp.endsWith(Specials.ELEMENT_END.getDescription() + node.getName() + Specials.NODE_END.getDescription())) {
            node.setValue(nodeValue(tmp));
            node.setHasChild(false);
        }

    }

}
/*
    public static Node getNodesTree() {
        String tmp;

        boolean inComment = false;

        try {
            tmp = reader.readLine();
            if (tmp!=null) {
                System.out.println(tmp);
                tmp = tmp.trim();

                if (!tmp.startsWith(Specials.ELEMENT_END.getDescription())){
                    Node root2 = new Node();
                    root2.setName(nodeName(tmp));
                    root2.setAttributeList(getAttribList(tmp));
                    if (tmp.endsWith(Specials.NODE_ONELINE.getDescription())){
                        return root2;
                    }

                    if (tmp.endsWith(Specials.ELEMENT_END.getDescription() + root.getName() + Specials.NODE_END.getDescription())) {
                        root2.setValue(nodeValue(tmp));
                    }
                    else {
                        while(!tmp.startsWith(Specials.ELEMENT_END.getDescription())) {
                            Node child = getNodesTree();
                            if (child.getName() != null)
                                root2.getNodeList().add(child);
                        }
                    }
                    return root2;
                }
                else
                    getNodesTree();

/*            tmp = (reader.readLine()).trim();
            if (tmp.equals(null))
                return null;
            if (!tmp.startsWith(Specials.ELEMENT_END.getDescription())) {
                root.setName(nodeName(tmp));
                root.setAttributeList(getAttribList(tmp));
            }

            if (tmp.endsWith(Specials.NODE_ONELINE.getDescription())) {
                return root;
            }
            if (tmp.endsWith(Specials.ELEMENT_END.getDescription() + root.getName() + Specials.NODE_END.getDescription())) {
                root.setValue(nodeValue(tmp));
            } else {
                while (!tmp.startsWith(Specials.ELEMENT_END.getDescription())){
                    int a = 1;
                    System.out.println(tmp);
                    root.getNodeList().add(getNodesTree());
                }
                /*do {
                    //tmp = (reader.readLine()).trim();
                    if (!tmp.startsWith("</"))
                        root.getNodeList().add(getNodesTree());
                }
                while (!tmp.startsWith(Specials.ELEMENT_END.getDescription() + root.getName()));*/

/*

            while ((tmp = (reader.readLine()).trim())!=null){
                if (inComment) {
                    tmp = deleteComment(tmp);
                }
                else{
                    if (tmp.contains(Specials.COMMENT_START.getDescription())) {
                        inComment = true;
                        tmp = deleteComment(tmp);

                    }

                }

                if (tmp!=null){

                }


            }


        }   catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public String deleteComment(String line) {
        if ((line.contains(Specials.COMMENT_START.getDescription()) && line.contains(Specials.COMMENT_END.getDescription())))
            return line.replaceAll("<!--.*.-_>", "");
        else if (line.contains(Specials.COMMENT_START.getDescription()))
            return line.replaceFirst("<!--.*", "");
        else if (line.contains(Specials.COMMENT_END.getDescription()))
            return line.replaceFirst(".*-->", "");
        else
            return null;
    }


*/
