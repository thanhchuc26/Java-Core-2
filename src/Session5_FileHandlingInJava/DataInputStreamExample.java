/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
public class DataInputStreamExample {

    public static void main(String[] args) {
        DataInputStream dataInput;

        int i;
        double d;
        boolean b;
        char ch;
        String str;

        try {
            dataInput = new DataInputStream(
                    new FileInputStream("d:/session05/DataOutputStream.txt"));
        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }

        try {
            i = dataInput.readInt();
            System.out.println("Reading Int: " + i);
            d = dataInput.readDouble();
            System.out.println("Reading Double: " + d);
            b = dataInput.readBoolean();
            System.out.println("Reading Boolean: " + b);
            d = dataInput.readDouble();
            System.out.println("Reading Double: " + d);
            ch = dataInput.readChar();
            System.out.println("Reading char: " + ch);
            str = dataInput.readUTF();
            System.out.println("Reading String: " + str);
        } catch (IOException exc) {
            System.out.println("Read error.");
        }
        try {
            dataInput.close();
        } catch (IOException ex) {
            Logger.getLogger(DataInputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*
DataInputStream được sử dụng trong ngữ cảnh của DataOutputStream 
và có thể được sử dụng để đọc các dữ liệu gốc (nguyên thủy) trong Java
*/
