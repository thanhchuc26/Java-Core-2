/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session8_MultithreadingAndConcurrency;

/**
 *
 * @author June
 */
class MyClass {

    private int a = 0;

    public synchronized void log1(String msg1, String msg2) {

        for (int i = 1; i <= 5; i++) {
            a++;
            System.out.println(msg1 + "-" + msg2 + " > A: " + a);

            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    public void log2(String msg1, String msg2) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                a++;
                System.out.println(msg1 + "-" + msg2 + " > A: " + a);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
        }
    }
}
public class Synchronization_Thread2 {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();

        Thread t1 = new Thread() {
            public void run() {
                obj1.log1("Thread 1", "Log 1");
//                 obj1.log2("Thread 1", "Log 2");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                obj1.log1("Thread 2", "Log 1");
//                 obj1.log2("Thread 2", "Log 2");
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                obj1.log1("Thread 3", "Log 1");
//                 obj1.log2("Thread 3", "Log 2");
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
