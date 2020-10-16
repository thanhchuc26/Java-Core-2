/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide6.java2;

/**
 *
 * @author June
 */
public class MainClass {
    public static void main(String[] args) {
        CounterThread ct1 = new CounterThread();
        CounterThread ct2 = new CounterThread();
        ct1.start();
        ct2.start();
        System.out.print("Completed");
    }
}
