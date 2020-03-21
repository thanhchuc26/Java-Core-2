/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author June
 */
public class ByteStreamExample {

    public static void main(String[] args) throws IOException {
        FileInputStream input = null;
        FileOutputStream output = null;
//        copy file d:/session05/bytestreaminput.txt thanh file d:/session05/bytestreamoutput.txt

        try {
            input = new FileInputStream("d:/session05/bytestreaminput.txt");
            output = new FileOutputStream("d:/session05/bytestreamoutput.txt");

            int c;
            while ((c = input.read()) != -1) {
                output.write(c);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }

}
