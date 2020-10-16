/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream("G:/FileDemo/hello.dat");
            String st = "Hello how are you today\n";
            fos.write(st.getBytes());
            System.out.println();
            fos.write(st.getBytes());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException ex) {
            }
        }
    }
}
