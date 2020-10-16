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
public class MainClassEx2 {
    public static void main(String[] args) {
        OddThread ot = new OddThread();
        EvenThread et = new EvenThread();
        
        ot.start();
        try {
            ot.join();
        } catch (InterruptedException ex) {}
        et.start();
        
        System.out.println("Completed");
               
    }
}
