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
class myThreadImplementsRunableInterface implements Runnable {

    String threadName;

    public myThreadImplementsRunableInterface() {
    }

    public myThreadImplementsRunableInterface(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name: " + this.getThreadName());
            Thread.currentThread().setName("abc");
            System.out.println("Active thread: "+Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myThreadExtendsThreadClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

public class create_thread_by_implements_runable_interface {

    public static void main(String[] args) {
        Thread myThread1 = new Thread(new myThreadImplementsRunableInterface("Thread 1"));
        Thread myThread2 = new Thread(new myThreadImplementsRunableInterface("Thread 2"));
        myThread1.start();
        myThread2.start();
    }

}
