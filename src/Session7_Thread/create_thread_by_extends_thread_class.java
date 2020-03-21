/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session7_Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
class myThreadExtendsThreadClass extends Thread {

    String threadName;

    public myThreadExtendsThreadClass(String threadName) {
        this.threadName = threadName;
    }

    public myThreadExtendsThreadClass() {
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name: " + this.getThreadName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myThreadExtendsThreadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class create_thread_by_extends_thread_class {

    public static void main(String[] args) {
        myThreadExtendsThreadClass myThread1 = new myThreadExtendsThreadClass("Thread 1");
        myThreadExtendsThreadClass myThread2 = new myThreadExtendsThreadClass("Thread 2");
        myThread1.start();
        myThread2.start();
    }
}
