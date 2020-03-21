/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author June
 */
public class _03_HashSetExample {
    public static void main(String[] args) {
        // Tạo một đối tượng Set có sức chứa ban đầu 10 phần tử.
       // Nếu số lượng phần tử thêm vào vượt quá sức chứa hiện tại.
       // Nó sẽ tự tăng sức chứa lên 80%.
       // Đặc điểm của HashSet là phần tử thêm vào sau đứng trước.
       Set<String> set = new HashSet<>(10, (float) 0.8);
 
       set.add("One");
       set.add("Two");
 
       // Trùng lặp xẩy ra.
       // Với HastSet: Nó sẽ ghi phần tử mới vào và remove phần tử cũ.
       set.add("One");
       set.add("Three");
       Iterator<String> it = set.iterator();
       while (it.hasNext()) {
           System.out.println(it.next());
       }
    }
}

/*
Set là một Interface con của Collection, nó có đầy đủ các tính năng của Collection, 
và có thêm một số tính năng:
Mô tả một tập hợp không cho phép chứa các phần tử trùng lặp
Có cho phép phần tử null, nếu có phần tử null thì chỉ có 1.

Lớp HashSet trong Java kế thừa AbstractSet và triển khai Set Interface.
Nó tạo một collection mà sử dụng một hash table để lưu giữ. 
Lưu ý trong hashset chỉ chứa các phần tử duy nhất, không chấp nhận 2 phần tử trùng nhau
*/