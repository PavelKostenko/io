package com.kostenko.io;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pavel
 */

import nu.xom.*;


import java.util.*;
public class e31_2 {

}


class People extends ArrayList<Person> {

    public People(String fileName) throws Exception {
        Document doc = new Builder().build(fileName);
        Elements elements
                = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People p = new People("People.xml");
        System.out.println(p);
    }
}
