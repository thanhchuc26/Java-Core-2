
package com.softech.slide6.java2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
public class CounterThread extends Thread{
    @Override
    public synchronized void run(){
        for (int i = 0; i < 50; i++) {
            System.out.print(" " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {}
        }
    }
}
