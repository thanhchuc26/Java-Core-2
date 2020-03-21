/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author June
 */
public class _05_TreeSetExample {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(5);
        System.out.print("TreeSet: ");
        for (Object i : treeSet) {
            System.out.print(i + " ");
        }
        System.out.println("");
//        HashSet hashSet = new HashSet();
//        hashSet.add(3);
//        hashSet.add(2);
//        hashSet.add(4);
//        hashSet.add(1);
//        hashSet.add(5);
//        for (Object i : hashSet) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//        Iterator iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//        }
    }
}

/*
Lớp TreeSet trong Java cài đặt (implement) Set Interface, nó sử dụng một cây (tree) cho lưu giữ các phần tử. TreeSet kế thừa lớp (extends) AbstractSet và cài đặt (implement) NavigableSet Interface. Các đối tượng của lớp TreeSet được lưu trữ theo thứ tự tăng dần.

Các điểm quan trọng về lớp TreeSet trong java là:
- Chỉ chứa các phần tử duy nhất giống như HashSet.
- Duy trì thứ tự tăng dần.
- TreeSet không cho phép chứa phần tử null.
- Bạn cần phải cung cấp bộ Comparator trong khi tạo một TreeSet. Nếu bạn không cung cấp bộ so sánh (Comparator) cho TreeSet, các phần tử sẽ được đặt theo thứ tự tăng dần.
- TreeSet không được đồng bộ. Để có được một TreeSet đồng bộ, hãy sử dụng phương thức Collections.synchronizedSortedSet ().
- Độ phức tạp của TreeSet là log(n) cho thao tác thêm (insertion), loại bỏ (removal) và truy xuất (retrieval).
- TreeSet sử dụng TreeMap để lưu trữ các phần tử, giống như HashSet và LinkedHashSet sử dụng HashMap và LinkedHashMap tương ứng để lưu trữ các phần tử của chúng.
*/
