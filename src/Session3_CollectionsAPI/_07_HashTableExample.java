/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author June
 */
public class _07_HashTableExample {
    public static void main(String[] args) {
        // tao mot hash map
      Hashtable balance = new Hashtable();
      Enumeration names;
      String str;
      double bal;

      balance.put("Zara", new Double(3434.34));
      balance.put("Mahnaz", new Double(123.22));
      balance.put("Ayan", new Double(1378.00));
      balance.put("Daisy", new Double(99.22));
      balance.put("Qadir", new Double(-19.08));

      // Hien thi tat ca balance trong hash table.
      names = balance.keys();
      while(names.hasMoreElements()) {
         str = (String) names.nextElement();
         System.out.println(str + ": " +
         balance.get(str));
      }
      System.out.println();
      // Gui 1,000 vao tai khoan cua Zara
      bal = ((Double)balance.get("Zara")).doubleValue();
      balance.put("Zara", new Double(bal+1000));
      System.out.println("Balance moi cua Zara la: " +
      balance.get("Zara"));
    }
}

/*
Lớp Hashtable trong Java là một phần của java.util gốc và là một sự triển khai cụ thể của một Dictionary.

Tuy nhiên, Java 2 đã thiết kế lại Hashtable để nó cũng triển khai Map Interface. 
Vì thế, lớp Hashtable bây giờ được tích hợp vào trong Collection Framework. 
Nó tương tự như HashMap, nhưng nó được đồng bộ.

Giống như HashMap, lớp Hashtable lưu giữ các cặp key/value trong một hash table. 
Khi sử dụng một Hashtable, bạn xác định một đối tượng mà được sử dụng như là một key, và value mà bạn muốn liên kết tới key đó. 
Key này sau đó được hash, và hash code kết quả được sử dụng như là chỉ mục, tại đó value được lưu giữ bên trong table đó.
*/
