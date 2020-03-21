/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author June
 */
public class _12_DequeExample {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("2");
        deque.addFirst("1");
        deque.addLast("3");

        for (String ele : deque) {
            System.out.print(ele + " ");
        }
        System.out.println("\n===============");
        deque.pollFirst();
        for (String ele : deque) {
            System.out.print(ele + " ");
        }
    }
}

/*
Chúng ta đã biết đến queue – hàng đợi, vào trước thì ra trước, 
thêm dữ liệu vào ở một đầu và lấy ra và loại bỏ ở một đầu khác. 
Deque thì khác, mặc dù là thừa kế từ Queue interface 
nhưng Deque cho phép thêm hoặc lấy ra và loại bỏ dữ liệu ở cả hai đầu: đầu và cuối. 
Deque giống như là một dạng cấu trúc dữ liệu cộng gộp những đặc trưng từ stack – xếp chồng và queue – hàng đợi. 
Nó bổ sung một loạt những method để đáp ứng khả năng đó như addFirst – addLast, 
getFirst – getLast, peekFirst – peekLast, pollFirst – pollLast,... 
Các cài đặt của nó gồm có ArrayDeque, LinkedBlockingDeque (trong concurrent package)
*/
