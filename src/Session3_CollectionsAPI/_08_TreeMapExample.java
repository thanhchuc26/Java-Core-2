/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author June
 */
public class _08_TreeMapExample {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
 
       map.put("01000005", "Tom");
       map.put("01000002", "Jerry");
       map.put("01000003", "Tom");
       map.put("01000004", "Donald");
 
       // Tập hợp này đã sắp xếp tăng dần
       Set<String> keys = map.keySet();
       for (String key : keys) {
           System.out.println("Phone: " + key);
       }
        
       System.out.println("-----");
 
       // Tập hợp này cũng đã được sắp xếp theo key.
       Set<Map.Entry<String, String>> entries = map.entrySet();
       for (Map.Entry<String, String> entry : entries) {
           System.out.println("Phone: " + entry.getKey());
       }
    }
}

/*
Interface SortedMap là interface con của Map. 
Nó đảm bảo rằng các cặp key/value được sắp xếp theo thứ tự tăng dần theo key.
Chỉ có một class trong bó java.util thi hành interface SortedMap, đó là TreeMap.
*/