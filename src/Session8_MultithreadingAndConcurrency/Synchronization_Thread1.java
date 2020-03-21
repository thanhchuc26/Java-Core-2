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
class DisPlay {

    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   " +Thread.currentThread().getName()+": "+ i);
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class unSynchronized_Thread extends Thread {

    private Thread t;
    private String threadName;
    DisPlay PD;

    public unSynchronized_Thread(String name, DisPlay pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        PD.printCount();
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class Synchronized_Thread extends Thread {

    private Thread t;
    private String threadName;
    DisPlay PD;

    Synchronized_Thread(String name, DisPlay pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized (PD) {
            PD.printCount();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}

public class Synchronization_Thread1 {

    static void unSynchronized() {
        DisPlay PD = new DisPlay();
        unSynchronized_Thread T1 = new unSynchronized_Thread("Thread - 1 ", PD);
        unSynchronized_Thread T2 = new unSynchronized_Thread("Thread - 2 ", PD);

        T1.start();
        T2.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }

    static void Synchronized() {
        DisPlay PD = new DisPlay();
        Synchronized_Thread T1 = new Synchronized_Thread("Thread - 1 ", PD);
        Synchronized_Thread T2 = new Synchronized_Thread("Thread - 2 ", PD);

        T1.start();
        T2.start();

        // wait for threads to end
        try {
            T1.join();
            T2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) {
//        unSynchronized();
        Synchronized();
    }
}

/*
Khi chúng ta bắt đầu 2 hay nhiều Thread trong cùng 1 chương trình, 
có thể xảy ra tình huống nhiều Thread cố gắng truy cập vào cùng 1 file 
hay 1 đối tượng nhất định gây ra tình trạng xung đột dữ liệu, mất dữ liệu.

Ví dụ, nếu nhiều luồng cố gắng để ghi vào cùng một tập tin, 
vì vậy tập tin có thể bị hỏng dữ liệu vì một trong những Thread có thể ghi đè dữ liệu 
trong khi một thread khác cũng mở cùng một tập tin, cùng lúc đó một thread khác nữa có thể được đóng tập tin đó.

Vì vậy, sinh ra nhu cầu để đồng bộ hóa các hành động của nhiều thread khác nhau (multi-thread) 
và chắc chắn rằng chỉ có một thread có thể truy cập các tài nguyên tại một thời điểm nào đó. 
Điều này được thực hiện bằng cách sử dụng một khái niệm gọi là monitors (giám sát).

Ngôn ngữ lập trình Java cung cấp một cách rất tiện lợi cho việc tạo ra Thread 
và đồng bộ hóa các nhiệm vụ bằng cách sử dụng các khối synchronized (đồng bộ). 
Bạn giữ các nguồn tài nguyên được chia sẻ trong khối này.

Một khối Synchronized block đánh dấu một phương thức hay một khối mã là được đồng bộ. 
Sử dụng khối đồng bộ trong Java có thể tránh xảy ra xung đột.
*/