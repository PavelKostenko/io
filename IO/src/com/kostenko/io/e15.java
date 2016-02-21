/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kostenko.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Pavel
 */
public class e15 {

}

class StoringAndRecoveringData {

    public static void main(String[] args)
            throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("d://temp//Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.writeInt(33);
        out.writeUTF("INT");
        out.writeBoolean(true);
        out.writeUTF("BOOLEAN");
        out.writeByte((byte)33);
        out.writeUTF("BYTE");
        out.writeChar('A');
        out.writeUTF("CHAR");
        out.writeFloat(33.34f);
        out.writeUTF("FLOAT");
        out.writeLong((long)33l);
        out.writeUTF("LONG");
        out.writeShort((short)33);
        out.writeUTF("SHORT");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("d://temp//Data.txt")));
        System.out.println(in.readDouble());
// Only readUTF() will recover the
// Java-UTF String properly:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readInt());
        System.out.println(in.readUTF());
        System.out.println(in.readBoolean());
        System.out.println(in.readUTF());
        System.out.println(in.readByte());
        System.out.println(in.readUTF());
        System.out.println(in.readChar());
        System.out.println(in.readUTF());
        System.out.println(in.readFloat());
        System.out.println(in.readUTF());
        System.out.println(in.readLong());
        System.out.println(in.readUTF());
        System.out.println(in.readShort());
        System.out.println(in.readUTF());
    }
}
