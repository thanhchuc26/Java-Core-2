/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 *
 * @author June
 */
public class DataInputStreamDemo {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("G:/FileDemo/Student.dat");
                DataInputStream dis = new DataInputStream(fis);
            ){
            String st = dis.readUTF();
            int age = dis.readInt();
            
            System.out.println("Read data: ");
            System.out.println("Message: " + st);
            System.out.println("Age: " + age);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());    
        }
    }
}
