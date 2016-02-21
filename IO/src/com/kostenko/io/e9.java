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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Pavel
 */
public class e9 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length!=1){
            System.out.println("Please provide a file name to read");
            System.exit(0);
        }
        BufferedReader bR = new BufferedReader(new FileReader(args[0]));
        LinkedList<String> lL = new LinkedList<String>();
        String s;
        while ((s = bR.readLine()) != null) {
            lL.add(s);
        }
        bR.close();
        System.out.println(lL);
        Iterator it = lL.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString().toUpperCase());
        }
    }
}
