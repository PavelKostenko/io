/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.regex.Pattern;
import net.mindview.util.TextFile;

/**
 *
 * @author Pavel
 */
public class e2 {

    public static void main(String[] args) {
        File file = new File(".");
        SortedDirList sDL = new SortedDirList(file);
        for (File f: sDL.list()){
            System.out.println(f);
        }
        System.out.println("***********");
        for (File f: sDL.list("test.txt")){
            System.out.println(f);
        }
    }
}

class SortedDirList {

    File file;

    public SortedDirList(File f) {
        file = f;
    }

    public File[] list() {
        if (file.isFile()) {
            return null;
        } else {
            File[] fileArray = file.listFiles();
            Arrays.sort(fileArray);
            return fileArray;
        }
    }

    public File[] list(String s) {
        if (file.isFile()) {
            return null;
        } else {
            File[] fileArray = file.listFiles(new DirFilter2(s));
            Arrays.sort(fileArray);
            return fileArray;
        }
    }
}

class DirFilter2 implements FilenameFilter {

    private Pattern pattern;

    public DirFilter2(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
