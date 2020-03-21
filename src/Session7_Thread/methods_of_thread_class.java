/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session7_Thread;

/**
 *
 * @author June
 */
public class methods_of_thread_class {

    static void activeCount() {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Number of active thread: " + Thread.activeCount());
            }
        });
        myThread.start();
    }

    static void currentThread() {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Current thread");
                System.out.println("Current thread: " + Thread.currentThread().getName());
            }
        });
        myThread.start();
    }

    static void isAlive() {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("myThread");
                System.out.println("Current thread: " + Thread.currentThread().getName());
            }
        });
        if (!myThread.isAlive()) {
            System.out.println("myThread is not alive");
        }
        myThread.start();
        if (myThread.isAlive()) {
            System.out.println("myThread is alive");
        }
    }

    public static void main(String[] args) {
//        activeCount();
//        currentThread();
        isAlive();
    }
}
