package com.kostenko.io;

//: io/BasicFileOutput.java
import java.io.*;

public class BasicFileOutput {
  static String file = "BasicFileOutput.out";
  public static void main(String[] args)
  throws IOException {
    BufferedReader in = new BufferedReader(
      new StringReader(
        BufferedInputFile.read("d:\\temp\\e7.txt")));
    LineNumberReader lR = new LineNumberReader(in);
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(file)));
    String s;
    while((s = lR.readLine()) != null )
      out.println(lR.getLineNumber() + ": " + s);
    out.close();
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
  }
} /* (Execute to see output) *///:~
