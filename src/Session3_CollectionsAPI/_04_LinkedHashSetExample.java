/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author June
 */
public class _04_LinkedHashSetExample {

    public static void main(String[] args) {
        // Create set
        Set<String> set = new LinkedHashSet<>();
        set.add("Item01");
        set.add("Item02");
        set.add("Item03");
        set.add("Item04");
        set.add("Item05");
        set.add("Item02");
        set.add("Item03");

        // Show set through for-each
        for (String item : set) {
            System.out.print(item + " ");
        }
    }
}

/*
Lớp LinkedHashSet trong Java kế thừa HashSet và triển khai Set Interface. Nó tạo một collection mà sử dụng một linked list để lưu giữ các phần tử theo thứ tự chúng đã được chèn.

LinkedHashSet chỉ chứa các phần tử duy nhất, không chấp nhận 2 phần tử trùng nhau.
LinkedHashSet đảm bảo thứ tự được thêm vào.
LinkedHashSet sử dụng đối tượng LinkedHashMap nội bộ để lưu trữ và xử lý các phần tử của nó.
LinkedHashSet cho phép chứa phần tử NULL.
LinkedHashSet không được đồng bộ. Để có LinkedHashSet đồng bộ, hãy sử dụng phương thức Collections.synchronizedSet().
 */
