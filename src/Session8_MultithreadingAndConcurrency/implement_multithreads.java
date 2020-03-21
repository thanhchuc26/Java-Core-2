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
public class implement_multithreads extends Thread {

    /* Variable to store the name of the thread */
    String name;

    /**
     * This method of Thread class is overridden to specify the action that will
     * be done when the thread begins execution.
     */
    @Override
    public void run() {
        while (true) {
            name = Thread.currentThread().getName();
            System.out.println(name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     * This is the entry point for the MultipleThreads class.
     */
    public static void main(String[] args) {
        implement_multithreads t1 = new implement_multithreads();
        implement_multithreads t2 = new implement_multithreads();
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();
        System.out.println("Number of threads running: " + Thread.activeCount());
    }
}

/*
Một chương trình multi-thread là một chương trình có chứa 2 hoặc nhiều phần chạy song song với nhau 
(Trong đó, mỗi phần được gọi là một thread). 
Multithreading là một dạng đặc biệt của multitasking (đa nhiệm vụ). 
Multithreading yêu cầu chi phí xử lý thấp hơn multitasking.

Multithreading giúp bạn viết được các chương trình làm việc hiệu quả hơn, thời gian nhàn rỗi của CPU sẽ được tận dụng tối đa hơn.
*/