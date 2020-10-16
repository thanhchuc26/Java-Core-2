/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import java.io.FileInputStream;

/**
 *
 * @author June
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("G:/FileDemo/Hello.dat");
            byte[] buffer = new byte[1024];
            int length;
            while((length = fis.read(buffer, 0 , 1024)) > 0){
                String st = new String(buffer, 0, length);
                System.out.println("Read string: " + st);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        
        
    }
}
