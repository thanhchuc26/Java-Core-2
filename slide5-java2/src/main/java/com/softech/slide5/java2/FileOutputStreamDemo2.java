/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import java.io.FileOutputStream;

/**
 *
 * @author June
 */
public class FileOutputStreamDemo2 {
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("G:/FileDemo/welcome.dat");
            ){
                String st = "Welcome to my try-resource in java";
                fos.write(st.getBytes());
                System.out.println("File created");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
