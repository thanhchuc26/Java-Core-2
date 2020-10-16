/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab5.java2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.XFile;

/**
 *
 * @author June
 */
public class MainClass {
    public static void main(String[] args){
        try {
            String path = "G:/FileDemo/lab5-java2.dat";
            XFile.write(path, "Hello How are you today".getBytes());
            
            byte[] data = XFile.read(path);
            
            System.out.println("Read data: " + new String(data));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
