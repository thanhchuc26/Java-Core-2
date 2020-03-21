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
class myThread extends Thread {

    public myThread() {
    }

    public myThread(String string) {
        super(string);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

public class methods_of_thread_class {

    static void joinMethod() throws InterruptedException {
        myThread myThread1 = new myThread();
        myThread myThread2 = new myThread();
        myThread1.start();
        //join() with no timeout
//        myThread1.join();
        
        //join() with timeout
//        myThread1.join(2500);
        myThread2.start();

        /*
        Hàm Join được sử dụng để giữ cho quá trình thực thi của hàm đang chạy không bị gián đoạn bởi các thread khác, 
        nói một cách khác nếu một thead đang chạy các thread khác sẽ phải chờ cho đến khi thread đó thực thi xong.
        
        Tại sao lại sử dụng hàm Join.
        Trong một chương trình Java thường có nhiều hơn một thread,trong đó có main thread - có chức năng khởi tạo và kích hoạt 
        để chạy các thread khác, tuy nhiên các main thread không đảm bảo các thread thực thi và kết thúc theo đúng thứ tự 
        mà chúng đã được khởi chạy.
         */
    }

    public static void main(String[] args) throws InterruptedException {
        joinMethod();
    }
}
