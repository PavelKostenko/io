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
import net.mindview.util.TextFile;

/**
 *
 * @author Pavel
 */
public class e1 {
}

class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[args.length - 1]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        if (new File(name).isFile()){
            String[] strings = TextFile.read(name).split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (pattern.matcher(strings[i]).matches()) {
                    return true;
                }
            }
        }
        return false;
    }
}