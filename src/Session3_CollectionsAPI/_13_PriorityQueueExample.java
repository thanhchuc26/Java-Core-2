/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author June
 */
public class _13_PriorityQueueExample {
    public static void main(String[] args) {
        // Với hàng đợi PriorityQueue phần tử sẽ được sắp xếp vị trí
        // theo trật tự tự nhiên của chúng.
        Queue<String> names = new PriorityQueue<String>();
 
        // offer(E): Trèn thêm phần tử vào hàng đợi.
        // Trả về true nếu thêm thành công.
        // Trả về false nếu hàng đợi không còn chỗ.
        names.offer("E");
        names.offer("A");
        names.offer("M");
 
        // add(E): Trèn thêm phần tử vào hàng đợi.
        // Trả về true nếu thêm thành công
        // Ném ra ngoại lệ nếu hàng đợi không còn chỗ.
        names.add("G");
        names.add("B");
 
        while (true) {
            // poll(): Lấy ra và loại bỏ phần tử đầu tiên ra khỏi hàng đợi.
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
PriorityQueue lưu trữ các phần tử trong nội bộ theo trật tự tự nhiên của các phần tử (nếu các phần tử này là kiểu Comparable),
hoặc theo một Comparator (bộ so sánh) được sét đặt cho PriorityQueue.
Chú ý rằng, một class có thể thi hành cả 2 interface List và Queue, chính vì vậy bạn không cần quan tâm tới các phần tử sắp xếp thế nào trong nội bộ của đối tượng class trên, nếu bạn coi nó như một hàng đợi, hãy xem cách thức truy cập vào phần tử của hàng đợi. 
Hãy xem các phương thức đặc trưng của Queue, nó mô phỏng hàng đợi giống hàng người xếp hàng ở siêu thị.
*/