/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab6.java2;

/**
 *
 * @author June
 */
public class MainClass {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        
        Thread th1 = new Thread(mt1);
        Thread th2 = new Thread(mt2);
        
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
        
        th1.start();
        th2.start();
        System.out.println("Completed!");
    }
}
