package com.kostenko.io;

//: io/BasicFileOutput.java
import io.*;
import java.io.*;

public class e14 {

    static String file = "BasicFileOutput.out";

    private static void writeToFile(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("d:\\temp\\e7.txt")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(fileName)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(fileName));
    }

    private static void writeToFile_slow(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("d:\\temp\\e7.txt")));
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(fileName));
    }

    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("d:\\temp\\e7.txt")));

        long start = System.nanoTime();
        writeToFile("d:\\temp\\BasicFileOutput.out");
        long duration = System.nanoTime() - start;
        System.out.println(duration);

        start = System.nanoTime();
        writeToFile_slow("d:\\temp\\BasicFileOutput1.out");
        long duration2 = System.nanoTime() - start;
        System.out.println(duration2);

    // Show the stored file:
    }
} /* (Execute to see output) *///:~
