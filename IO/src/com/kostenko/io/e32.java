/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.mindview.util.TextFile;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 *
 * @author Pavel
 */
public class e32 {

    public static Element getXML(Entry<String, Integer> e) {
        Element entry = new Element("Entry");
        Element word = new Element("Word");
        Element number = new Element("Number");
        word.appendChild(e.getKey());
        number.appendChild(e.getValue() + "");
        entry.appendChild(word);
        entry.appendChild(number);
        return entry;
    }

    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> aL = new TextFile("d:\\temp\\test.txt", "\\W+");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : aL) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);

        Element root = new Element("Words");
        for (Entry<String, Integer> e : map.entrySet()) {
            root.appendChild(getXML(e));
        }

        Document doc = new Document(root);
        format(System.out,doc);
        format(new BufferedOutputStream(new FileOutputStream("d:\\temp\\e32.xml")),doc);
        
    }
}
