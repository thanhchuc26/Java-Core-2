/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.Vector;

/**
 *
 * @author June
 */
public class _01_VectorExample {
    public static void main(String[] args) {
        // Khởi tạo một đối tượng Vector
       // Sức chứa ban đầu 10.
       // Tự động tăng sức chứa thêm 5 nếu số phần tử vượt qua sức chứa hiện
       // tại.
 
       Vector<Integer> myvector= new Vector<Integer>(10, 5);
 
       myvector.add(123);
       myvector.add(245);
       myvector.add(new Integer(345));
       myvector.add(null);
       // In ra so phan tu co trong Vector (Khong phai la dung luong)
       System.out.println("Size:" + myvector.size());// =4
 
       // Lấy ra phần tử tại chỉ số 1.
       // Giống với method get(int)
       Integer i = myvector.elementAt(1);
       System.out.println("v.elementAt(1)=" + i);// 245
 
       // Sét đặt lại phần tử tại chỉ số 1
       // Method này trả về phần tử cũ.
       myvector.setElementAt(1000, 1);
       //
       System.out.println("New value:" + myvector.get(1));// =1000 .
    }
}

/*
Vector là một class có tính năng tương tự ArrayList. 
Khác biệt là các method của Vector được đồng bộ hóa, còn ArrayList thì không
*/