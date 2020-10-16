/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 *
 * @author June
 */
public class DataOutputStreamDemo {
    public static void main(String[] args) {
        try(    
                FileOutputStream fos = new FileOutputStream("G:/FileDemo/Student.dat");
                DataOutputStream dos = new DataOutputStream(fos);
            ) {
                dos.writeUTF("Hello World");
                dos.writeInt(25);
                System.out.println("Successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
