/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
public class DataOutputStreamExample {
    public static void main(String[] args) {
        DataOutputStream dataOutput;
        
        int i = 2017;
        double d = 3.14;
        boolean b = true;
        char ch = 'A';
        String str = "Trung tâm Softech.vn";
        
        try {
            dataOutput = new DataOutputStream(new FileOutputStream("d:/session05/DataOutputStream.txt"));
        } catch (IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }
        try {
            dataOutput.writeInt(i);
            dataOutput.writeDouble(d);
            dataOutput.writeBoolean(b);
            dataOutput.writeDouble(12.2 * 7.4);
            dataOutput.writeChar(ch);
            dataOutput.writeUTF(str);
        } catch (IOException exc) {
            System.out.println("Write error.");
        }
        try {
            dataOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(DataOutputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
DataOutputStream cho phép ghi các kiểu dữ liệu gốc (nguyên thủy) trong Java tới một nguồn output
*/