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
class None_DeamonThread extends Thread {
 
  @Override
  public void run() {
      int i = 0;
 
      // Vòng lặp 10 lần. Luồng này sẽ kết thúc.
      while (i < 10) {
          System.out.println("  - Hello from None Deamon Thread " + i++);
          try {
              // Ngủ 1 giây.
              Thread.sleep(1000);
          } catch (InterruptedException e) {
          }
      }
 
      // Ghi ra thông báo luồng này kết thúc.
      System.out.println("\n==> None Deamon Thread ending\n");
  }
}
class Deamon_Thread extends Thread {
 
  @Override
  public void run() {
      int count = 0;
      
      // Vòng lặp vô tận.
      while (true) {
          System.out.println("+ Hello from Deamon Thread " + count++);
          try {
              // Ngủ 2 giây.
              sleep(2000);
          } catch (InterruptedException e) {
          }
      }
  }
}
public class DeamonThread {
    public static void main(String[] args) {
        System.out.println("==> Main Thread running..\n");
       // Tạo một Thread
       Thread deamonThread = new Deamon_Thread();
       // Set nó là Deamon Thread.
       deamonThread.setDaemon(true);
       deamonThread.start();
 
       // Tạo một Thread khác
       new None_DeamonThread().start();
 
       try {
           // Ngủ 5 giây.
           Thread.sleep(5000);
       } catch (InterruptedException e) {
       }
        
       // Ghi ra thông báo luồng main này kết thúc.
       System.out.println("\n==> Main Thread ending\n");
    }
}


/*
Java chia thread làm 2 loại một loại thông thường và Deamon Thread. Chúng chỉ khác nhau ở cách thức ngừng hoạt động. 
Trong một chương trình các luồng thông thường và luồng Deamon chạy song song với nhau. 
Khi tất cả các luồng thông thường kết thúc, mọi luồng Deamon cũng sẽ bị kết thúc theo bất kể nó đang làm việc gì.

Chú ý: 

1. Sử dụng setDeamon(boolean) để sét đặt một luồng là Deamon hoặc không. 
Chú ý, bạn chỉ có thể gọi hàm setDeamon(boolean) khi thread chưa được chạy. 
Điều đó có nghĩa là khi thread đã chạy bạn không thể chuyển luồng từ non-deamon sang deamon và ngược lại. 

2. Khi một luồng mới được tạo ra, nó được thừa hưởng đặc tính deamon từ luồng cha.  
Như vậy khi bạn tạo một luồng trong hàm main của 1 class nó vốn là luồng non-deamon, vì vậy thread tạo ra mặc định cũng là none-deamon. 
Như vậy nếu bạn tạo một luồng mới trong một luồng Deamon, mặc định nó cũng sẽ là Deamon.

Ví dụ:
Thread thread = new MyThread();
// set luồng này là deamon.
// Chỉ gọi được method này khi thread chưa start.
// Trong trường hợp start rồi sẽ bị một ngoại lệ.
thread.setDeamon(true);
 
// Set luồng này là non-deamon.
// Chỉ gọi được method này khi thread chưa start.
// Trong trường hợp start rồi sẽ bị một ngoại lệ.
thread.setDeamon(false);
*/