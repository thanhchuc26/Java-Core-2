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
public class _17_ArrayDequeExample {

    static void createArrayDeque() {
        // Creating Deque and adding elements
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Basic");
        deque.add("OOP");
        deque.add("Collection");
        // Traversing elements
        for (String str : deque) {
            System.out.println(str);
        }
    }

    static void createArrayDequeAsQueue() {
        // Creating an array deque
        Deque<String> arrayDeque = new ArrayDeque<String>();

        // Adding elements at the tail of arrayDeque
        arrayDeque.offer("One");
        arrayDeque.offer("Two");
        arrayDeque.offer("Three");
        arrayDeque.offer("Four");
        arrayDeque.offer("Five");

        // Printing the elements of arrayDeque
        System.out.println(arrayDeque); // Output : [One, Two, Three, Four, Five]

        // Removing the elements from the head of arrayDeque
        System.out.println(arrayDeque.poll()); // Output : One
        System.out.println(arrayDeque.poll()); // Output : Two
    }

    static void createArrayDequeAsStack() {
        // Creating an array deque
        Deque<String> arrayDeque = new ArrayDeque<String>();

        // pushing elements into arrayDeque
        arrayDeque.push("One");
        arrayDeque.push("Two");
        arrayDeque.push("Three");
        arrayDeque.push("Four");
        arrayDeque.push("Five");

        // Printing the elements of arrayDeque
        System.out.println(arrayDeque); // Output : [Five, Four, Three, Two, One]

        // popping up the elements from arrayDeque
        System.out.println(arrayDeque.pop()); // Output : Five
        System.out.println(arrayDeque.pop()); // Output : Four
    }

    public static void main(String[] args) {
        createArrayDeque();
        createArrayDequeAsQueue();
        createArrayDequeAsStack();
    }
}

/*
- Lớp ArrayDeque mở rộng lớp AbstractCollection và cài đặt Deque Interface.
- Không giống như Queue, Dequeue có thể thêm hoặc xóa các phần tử từ cả hai đầu.
- ArrayDeque là cài đặt một mảng có thể thay đổi kích thước, Deque Interface tương tự như lớp ArrayList là một cài đặt List Interface có thể điều chỉnh lại kích thước. Tuy nhiên, ArrayDeque không phải là List.
- ArrayDeque không có giới hạn dung lượng (compacity). Nó sẽ phát triển tự động khi chúng ta thêm các phần tử.
- Dung lượng ban đầu mặc định của ArrayDeque là 16. Nó sẽ tự tăng dung lượng với số mũ của 2 khi kích thước vượt quá dung lượng.
- ArrayDeque không phải là thread an toàn.
- ArrayDeque có thể được sử dụng như một ngăn xếp (Stack – LIFO) cũng như một hàng đợi (Queue – FIFO). ArrayDeque nhanh hơn lớp Stack khi được sử dụng như một ngăn xếp (Stack) và nhanh hơn lớp LinkedList khi được sử dụng như một hàng đợi (Queue).
- Hiệu suất của ArrayDeque đôi khi được coi là tốt nhất trong Collection Framework. Nó cho phép thực hiện O(1) để chèn, loại bỏ và truy xuất. Lớp ArrayDeque được đề nghị thay vì lớp Stack (khi bạn muốn cấu trúc ngăn xếp dữ liệu) và thay vì lớp LinkedList (khi bạn muốn cấu trúc dữ liệu hàng đợi).
- Không thể thực hiện các thao tác liên quan đến index (random access) trên ArrayDeque. ArrayDeque không có phương thức để hỗ trợ các thao tác đó.
- Các phần tử Null không được phép trong ArrayDeque.
 */
