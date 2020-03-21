/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.LinkedList;

/**
 *
 * @author June
 */
public class _02_LinkedListExample {

    public static void main(String[] args) {
        // Tạo một đối tượng tập hợp - LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Thêm một số phần tử vào danh sách
        list.add("F");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add("C");
        // Thêm phần tử vào cuối danh sách.
        list.addLast("Z");
        // Thêm phần tử vào đầu danh sách
        list.addFirst("A");
        // Thêm phần tử vào ví trí có chỉ số 1.
        list.add(1, "A2");

        // Ghi ra danh sách:
        System.out.println("Original contents of list: " + list);

        // Xóa phần tử khỏi danh sách
        list.remove("F");
        // Xóa phần tử tại vị trí có chỉ số 2.
        list.remove(2);

        // In ra danh sách sau khi đã xóa 2 phần tử.
        System.out.println("Contents of list after deletion: " + list);

        // Xóa phần tử đầu tiên và cuối cùng trong danh sách.
        list.removeFirst();
        list.removeLast();

        // In ra danh sách sau khi đã xóa
        System.out.println("List after deleting first and last: " + list);

        Object val = list.get(2);
        // Sét đặt lại phần tử tại vị trí có chỉ số 2.
        list.set(2, (String) val + " Changed");
        System.out.println("List after change: " + list);
    }
}

/*
Danh sách có kết nối ( Linked List) là một trong các cách quản lý danh sách dữ liệu khắc phục được các nhược điểm của mảng.

Lớp LinkedList trong java sử dụng cấu trúc danh sách liên kết Doubly Linked List để lưu trữ các phần tử.

Những điểm cần ghi nhớ về lớp LinkedList:
- Có thể chứa các phần tử trùng lặp.
- Duy trì thứ tự của phần tử được thêm vào.
- Không đồng bộ (non-synchronized).
- Thao tác thêm/ xóa (add/ remove) phần tử nhanh vì không cần phải dịch chuyển nếu bất kỳ phần tử nào thêm/ xoá khỏi danh sách.
- LinkedList có thể được sử dụng như danh sách (list), stack (ngăn xếp) hoặc queue (hàng đợi).
- Các phần tử trong LinkedList có thể nằm cách ly nhau (không liên tục) trong bộ nhớ. Nó là một liên kết có tính hai chiều giữa các phần tử. Mỗi phần tử trong danh sách cầm giữ một tham chiếu đến phần tử đằng trước nó và tham chiếu đến phần tử ngay sau nó.
*/
