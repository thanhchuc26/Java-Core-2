/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author June
 */
public class XFile {
    
    public static Object readObject(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        try(
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
            ){
            return ois.readObject();
        } 
    }
    
    public static void writeObject(String path, Object data) throws FileNotFoundException, IOException{
        try(
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
            ){
            oos.writeObject(data);
        }
            
    }
    
    public static byte[] read(String path) throws FileNotFoundException, IOException{
        try(
                FileInputStream fis = new FileInputStream("G:/FileDemo/Exercise1.dat");
            ) {
            int length = fis.available();
            
            byte[] buffer = new byte[length];
            
            fis.read(buffer);
            
            return buffer;
            
        }
    }
    public static void write(String path, byte[] data) throws FileNotFoundException, IOException{
        try(FileOutputStream fos = new FileOutputStream(path);){
            fos.write(data);
        }
    }
}    