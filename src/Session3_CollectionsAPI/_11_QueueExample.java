/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author June
 */
public class _11_QueueExample {
    public static void main(String[] args) {
        Queue<String> names = new LinkedList<>();
 
       // offer(E): Trèn thêm phần tử vào hàng đợi.
       // Với hàng đợi LinkedList phần tử sẽ trèn vào cuối hàng đợi.
       // Trả về true nếu thêm thành công.
       // Trả về false nếu hàng đợi không còn chỗ.
       names.offer("E");
       names.offer("A");
       names.offer("M");
 
       // add(E): Trèn thêm phần tử vào hàng đợi.
       // Với hàng đợi LinkedList phần tử sẽ trèn vào cuối hàng đợi.
       // Trả về true nếu thêm thành công
       // Ném ra ngoại lệ nếu hàng đợi không còn chỗ.
       names.add("G");
       names.add("B");
 
       while (true) {
           // Lấy ra và loại bỏ phần tử đầu tiên ra khỏi hàng đợi.
           // Trả về null nếu không còn phần tử nào trong hàng đợi.
           String name = names.poll();
           if (name == null) {
               break;
           }
           System.out.println("Name=" + name);
       }
       
    }
}

/*
Queue (hàng đợi) là một Interface con của Collection, nó có đầy đủ các tính năng của Collection, 
nó khá giống với List, tuy nhiên mục đích sử dụng hơi khác nhau. 
Queue được thiết kế để bạn chỉ có thể truy cập phần tử ở đầu hàng đợi, và khi loại bỏ phần tử nó loại phần tử đứng đầu hàng đợi. 
Nó giống như hàng người xếp hàng ở siêu thị, chỉ người đứng đầu hàng đợi mới được phục vụ, 
người mới đến sẽ được trèn vào hàng đợi, vị trí được trèn vào có thể không phải là cuối hàng. 
Vị trí phần từ được trèn vào phụ thuộc vào loại hàng đợi và độ ưu tiên của phần tử.
Là tập hợp cho phép các phần tử trùng lặp.
Không cho phép phần tử null.

Có hai class thi hành interface Queue.
java.util.LinkedList
java.util.PriorityQueue

LinkedList là một hàng đợi khá chuẩn. Nhưng nhớ rằng LinkedList thi hành cả 2 interface List và Queue. 
*/