/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

/**
 *
 * @author Pavel
 */
import nu.xom.*;
import java.io.*;
import java.util.*;

public class e31_1 {}

class Person {

    private String first, last, address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
// Produce an XML Element from this Person object:

    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        Element addressPart = new Element("address");
        addressPart.appendChild(address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(addressPart);
        return person;
    }
// Constructor to restore a Person from an XML Element:

    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }

    public String toString() {
        return first + " " + last + " " + address;
    }
// Make it human-readable:

    public static void
            format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "Street 1"),
                new Person("Gonzo", "The Great", "Street 2"),
                new Person("Phillip J.", "Fry", "Street 3"));
        System.out.println(people);
        Element root = new Element("people");
        for (Person p : people) {
            root.appendChild(p.getXML());
        }
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream(
                "People.xml")), doc);
    }
}
