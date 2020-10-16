/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide5.java2;

import com.softech.slide5.model.Product;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author June
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("G:/FileDemo/Product.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
            Product product = (Product)ois.readObject();
            System.out.println("ProductID:" + product.getProductId());
            System.out.println("Name: " + product.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
