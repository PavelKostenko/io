/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.io.File;
import net.mindview.util.Directory;
import net.mindview.util.Directory.TreeInfo;

/**
 *
 * @author Pavel
 */
public class e4 {
    public static long measureSize(TreeInfo treeInfo){
        long sum = 0;
        for (File f: treeInfo){
            sum = sum + f.length();
        }
        return sum;
    }
    public static void main(String[] args) {
        TreeInfo tI = Directory.walk(".", ".*");
        System.out.println(tI);
        System.out.println();
        System.out.println(measureSize(tI));
    }
}
