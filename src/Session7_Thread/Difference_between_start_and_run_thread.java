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
class myThread extends Thread {

    public myThread(String string) {
        super(string);
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + this.getName());
    }
}

public class Difference_between_start_and_run_thread {

    public static void main(String[] args) {
        myThread myThread1 = new myThread("Thread 1");
        myThread1.run();
        myThread1.run();

//        myThread1.start();
//        myThread1.start();
    }

}

/*
Như chúng ta đã biết, code xử lý của các thread được khai báo bên trong phương thức run() của thread đó. 
Java cung cấp cho chúng ta 2 phương thức để chạy phương thức này là:
Thread.start()
Thread.run()

Cả 2 phương thức này đều có chức năng gọi đến phương thức run() của thread 
và thực thi các dòng code bên trong phương thức này. Vậy sự khác nhau giữa chúng là:
Khi chúng ta gọi phương thức start(), 1 thread mới sẽ được tạo và code trong phương thức run() sẽ được thực thi trong thread mới này. 
Nếu chúng ta gọi phương thức run(), không có thread mới nào được tạo và code trong run() sẽ được thực thi tại thread hiện tại.
Ngoài ra, chúng ta không thể gọi phương thức start() 2 lần trên đối tượng thread, việc này sẽ quăng ra lỗi IllegalStateException trong Java. 
Trong khi đó, chúng ta có thể gọi phương thức run() 2 lần trên đối tượng thread.
 */
