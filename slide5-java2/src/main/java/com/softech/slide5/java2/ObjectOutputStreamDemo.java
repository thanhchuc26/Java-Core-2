/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import com.softech.slide5.model.Product;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author June
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        try(
                FileOutputStream fos = new FileOutputStream("G:/FileDemo/Product.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
            ) {
            Product p = new Product("P01", "TV");
            oos.writeObject(oos);
            System.out.println("Successfully");
        } catch (Exception e) {
        }
    }
}
