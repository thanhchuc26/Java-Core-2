/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author June
 */
public class _00_ListExample {

    public static void main(String[] args) {

        // Tạo một đối tượng List (Chỉ chứa các String)
        List<String> mylist = new ArrayList<String>();
        mylist.add("One");
        mylist.add("Two");
        mylist.add("Three");
        mylist.add("Four");

        // Lấy ra đối tượng ListIterator để duyệt danh sách.
        ListIterator<String> mylistIterator = mylist.listIterator();

        // Hiện tại con trỏ đang đứng tại ví trí đầu danh sách.
        // Đứng tại chỉ số 0.
        // Lấy ra phần tử đầu tiên trong danh sách, con trỏ tiến một bước.
        String first = mylistIterator.next();
        System.out.println("first:" + first);// -->"One"

        // Hiện tại con trỏ đang đứng tại vị trí chỉ số 1
        // Lấy ra phần tử tiếp theo.
        String second = mylistIterator.next();
        System.out.println("second:" + second);// -->"Two"

        // Kiểm tra xem con trỏ có thể nhẩy lùi 1 vị trí không
        if (mylistIterator.hasPrevious()) {
            // Lùi con trỏ 1 trị trí.
            String value = mylistIterator.previous();
            System.out.println("value:" + value);// -->"Two"
        }

        System.out.println(" ----- ");

        while (mylistIterator.hasNext()) {
            String value = mylistIterator.next();
            System.out.println("value:" + value);
        }
    }
}

/*
List là một interface con của Collection nó có đầy đủ các tính năng của Collection 
đồng thời có thêm một số tính chất đặc biệt:
Cho phép phần tử trùng lặp
Cho phép 0 hoặc nhiều phần tử null.
Là một tập hợp có tuần tự.
Đồng thời ngoài cách truy cập bằng Iterator có thể truy cập bằng cách sử dụng ListIterator. 
ListIterator cho phép tiến hoặc lùi vị trí con trỏ.
*/
