/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Pavel
 */
public class e27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Second sec = new Second();
        First fir = new First(sec);
        System.out.println("fir: " + fir);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\temp\\e17.dot"));
        oos.writeObject(fir);
        oos.close();
        System.out.println("Serializations is done");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\temp\\e17.dot"));
        First newFir = (First)ois.readObject();
        System.out.println(newFir);
    }
}

class First implements Serializable{
    public static long counter = 10;
    private final long id = counter++;
    private Second sec;
    public First(Second s){
        sec = s;
    }
    public String toString(){
        return id + "; " + sec;
    }
}

class Second implements Serializable{
    public static long counter = 100;
    private final long id = counter++;
    public String toString(){
        return id + "";
    }
}
