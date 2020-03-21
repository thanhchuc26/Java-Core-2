/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author June
 */
public class methods_of_Collection {

    static void showArrayList(ArrayList arrayList) {
        for (Object i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("");
    }

    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            //method add(): thêm 1 phần tử vào cuối arraylist
            arrayList1.add(i);
        }
        System.out.print("Khởi tạo arrayList1: ");
        showArrayList(arrayList1);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 11; i <= 12; i++) {
            arrayList2.add(i);
        }

        //addAll(): thêm 1 tập hợp các phần tử từ 1 tập hợp khác
        arrayList1.addAll(arrayList2);
        System.out.print("arrayList1 sau khi addAll() arrayList2: ");
        showArrayList(arrayList1);

        //remove(): xóa 1 phần tử trong arrayList
        arrayList1.remove(10);  //xóa phần tử thứ 10 trong arrayList
        System.out.print("arrayList1 sau khi xóa phần tử thứ 11: ");
        showArrayList(arrayList1);

        //removeAll(): xóa 1 tập hợp các phần tử khỏi tập hợp hiện tại
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(10);
        arrayList3.add(12);
        arrayList1.removeAll(arrayList3);   //xóa các phần tử trong arrayList1 có giá trị giống trong arrayList3
        System.out.print("arrayList1 sau khi xóa các phần tử từ arrayList3: ");
        showArrayList(arrayList1);

        //clear(): xóa hết các phần tử trong 1 tập hợp
        arrayList3.clear();
        System.out.print("arrayList3 sau khi clear(): ");
        showArrayList(arrayList3);

        //size(): trả về số lượng các phần tử có trong 1 tập hợp
        System.out.println("arrayList1 có " + arrayList1.size() + " phần tử");
        System.out.println("");

        //isEmpty(): trả về true nếu tập hợp rỗng
        if (arrayList3.isEmpty()) {
            System.out.println("arrayList3 là 1 tập hợp rỗng");
        } else {
            System.out.println("arrayList3 không phải là 1 tập hợp rỗng");
        }
        System.out.println("");

        //contains(): trả về true nếu giá trị của contains() có trong tập hợp
        int socantim = 1;
        if (arrayList1.contains(socantim)) {
            System.out.println("Số " + socantim + " có trong arrayList1");
        } else {
            System.out.println("Số " + socantim + " không có trong arrayList1");
        }
        System.out.println("");

        //containsAll(): trả về true nếu tập hợp của containsAll() là 1 tập hợp con của 1 tập hợp khác
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(1);
        arrayList4.add(4);
        if (arrayList1.containsAll(arrayList4)) {
            System.out.println("arrayList4 là tập hợp con của arrayList1");
        } else {
            System.out.println("arrayList4 không là tập hợp con của arrayList1");
        }
        System.out.println("");

        //retainAll(): xóa các phần tử không có trong retainAll()
        arrayList1.removeAll(arrayList4);
        System.out.print("arrayList1 sau khi retainAll() từ arrayList4: ");
        showArrayList(arrayList1);

        //iterator(): dùng iterator() để duyệt arrayList1
        System.out.print("arrayList1 khi dùng iterator() để duyệt: ");
        Iterator iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
