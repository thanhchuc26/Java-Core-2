/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session8_MultithreadingAndConcurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
class myThread_join2 extends Thread {

    @Override
    public void run() {
//        System.out.println(this.getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(myThread_join2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public myThread_join2() {
    }

    public myThread_join2(String string) {
        super(string);
    }

}

public class join_method_2 {

    public static void main(String[] args) throws InterruptedException {
        myThread_join2 myThread1 = new myThread_join2("Thread 1");
        myThread_join2 myThread2 = new myThread_join2("Thread 2");
        myThread1.start();
        myThread1.join(5000);
        myThread2.start();
    }
}
