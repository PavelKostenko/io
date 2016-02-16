/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author Pavel
 */
public class e3 {

    public static void main(String[] args) {
        File path = new File(".");
        File [] list;
        if (args.length == 0) {
            list = path.listFiles();
        } else {
            list = path.listFiles(new DirFilter3(args[0]));
        }
        Arrays.sort(list);
        long sum=0;
        for (File dirItem : list) {
            System.out.println(dirItem + " size is " + dirItem.length());
            sum=sum+dirItem.length();
        }
        System.out.println();
        System.out.println("Total sum is " + sum);
    }
}

class DirFilter3 implements FilenameFilter {

    private Pattern pattern;

    public DirFilter3(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
