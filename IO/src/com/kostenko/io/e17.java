/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import net.mindview.util.TextFile;

/**
 *
 * @author Pavel
 */
public class e17 {

    static char[] chars = TextFile.read("d:\\temp\\test.txt").toCharArray();
    static HashMap<Character, Integer> letterFreq
            = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        for (char c : chars) {
            if (letterFreq.get(c) != null) {
                letterFreq.put(c, letterFreq.get(c) + 1);
            } else {
                letterFreq.put(c, 1);
            }
        }
        System.out.println(letterFreq);
    }
}
