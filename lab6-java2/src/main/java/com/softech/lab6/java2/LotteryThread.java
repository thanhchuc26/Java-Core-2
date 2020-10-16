/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab6.java2;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author June
 */
public class LotteryThread extends Thread{
    private JTextField txt;

    public LotteryThread(JTextField txt) {
        this.txt = txt;
    }
    
    
    @Override
            
    public void run(){
        Date now = new Date();
        Random r = new Random(now.getTime());
        for (int i = 0; i < 100; i++) {
            int num = Math.abs(r.nextInt() % 10);
            txt.setText("" + num);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {}
        }
    }
}
