/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.Stack;

/**
 *
 * @author June
 */
public class _10_StackExample {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        // khởi tạo giá trị cho stack
        // push(): thêm 1 phần tử vào stack
        for (int i = 1; i <= 5; i++) {
            myStack.push(i);
        }
        // hiển thị các phần tử của stack
        System.out.print("Giá trị các phần tử của stack: ");
        for (int i = 0; i < myStack.size(); i++) {
            System.out.print(myStack.get(i) + " ");
        }
        System.out.println("");

        // empty(): kiểm tra stack có rỗng hay không
        if (myStack.empty()) {
            System.out.println("Stack rỗng");
        } else {
            System.out.println("Stack hiện đang có " + myStack.size() + " phần tử");
        }

        // peek(): lấy giá trị phần tử ở đỉnh của stack nhưng ko xóa giá trị đó khỏi stack
        System.out.println("Giá trị phần tử tại đỉnh của stack là: " + myStack.peek());

        // search(): tìm 1 phần tử có tồn tại trong stack hay không, nếu tồn tại thì trả về vị trí của phần tử
        System.out.println("Vị trí xuất hiện của phần tử có giá trị = 2 trong stack là: " + myStack.search(2));
        
        //pop(): lấy giá trị tại đỉnh của stack và xóa giá trị đó ra khỏi stack
        System.out.print("Giá trị các phần tử của stack: ");
        for (int i = myStack.size(); i > 0; i--) {
            System.out.print(myStack.peek() + " ");

        }
        System.out.println("");
        System.out.println("Kích thước của stack sau khi pop() tất cả các phần tử là: "+myStack.size());
    }
}

/*
Stack là một cấu trúc dữ liệu lưu trữ nhiều phần tử dữ liệu. Stack hoạt động theo cơ chế vào sau ra trước Last In/First Out (LIFO).
Trong Stack có các thao tác cơ bản:
+ Push : thêm 1 phần tử vào đỉnh Stack
+ Pop : lấy 1 phần tử từ đỉnh Stack
+ Peek: trả về phần tử đầu Stack mà không loại bỏ nó ra khỏi Stack
+ isEmpty: Kiểm tra Stack có rỗng ko?
+ Search: trả về vị trí phần tử trong Stack tính từ đỉnh stack nếu ko thấy trả về -1
*/