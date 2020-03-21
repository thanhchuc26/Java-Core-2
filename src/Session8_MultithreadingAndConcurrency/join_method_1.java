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
class myThread_join1 implements Runnable {

    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Bắt đầu thread: " + t.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Kết thúc thread:" + t.getName());
    }
}

public class join_method_1 {

    static void unjoin_thread() {
        Thread th1 = new Thread(new myThread_join1(), "th1");
        Thread th2 = new Thread(new myThread_join1(), "th2");
        Thread th3 = new Thread(new myThread_join1(), "th3");
        th1.start();
        th2.start();
        th3.start();
    }

    static void join_thread() {
        Thread th1 = new Thread(new myThread_join1(), "th1");
        Thread th2 = new Thread(new myThread_join1(), "th2");
        Thread th3 = new Thread(new myThread_join1(), "th3");
        //khởi chạy thread 1.
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //khởi chạy thread 2.
        th2.start();
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //khởi chạy thread 3.
        th3.start();
        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        unjoin_thread();
        join_thread();
    }
}

/*
Hàm Join được sử dụng để giữ cho quá trình thực thi của hàm đang chạy không bị gián đoạn bởi các thread khác, 
nói một cách khác nếu một thead đang chạy các thread khác sẽ phải chờ cho đến khi thread đó thực thi xong.

Tạo sao lại sử dụng hàm Join: Trong một chương trình Java thường có nhiều hơn một thread,
trong đó có main thread - có chức năng khởi tạo và kích hoạt để chạy các thread khác, 
tuy nhiên các main thread không đảm bảo các thread thực thi và kết thúc theo đúng thứ tự mà chúng đã được khởi chạy.
*/
