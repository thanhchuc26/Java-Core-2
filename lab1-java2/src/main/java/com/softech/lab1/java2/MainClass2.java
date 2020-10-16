/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab1.java2;

import java.util.Scanner;

/**
 *
 * @author June
 */
public class MainClass2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            Product p;
            if(i!=0)
                p = new Product();
            else
                p = new NoTaxProduct();
            System.out.println("Product " + (i) +": ");
            System.out.print("Name: ");
            String st = s.nextLine();
            p.setName(st);
            System.out.print("Price: ");
            Float f = s.nextFloat();
            p.setPrice(f);
            s.nextLine();
            System.out.printf("Name: %s - Price: %f - Tax: %.2f \n", p.getName(), p.getPrice(), p.getImportTax());
        }
    }
}
