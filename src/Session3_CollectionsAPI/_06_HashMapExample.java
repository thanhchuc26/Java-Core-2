/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.HashMap;

/**
 *
 * @author June
 */
public class _06_HashMapExample {
    public static void main(String[] args) {
        // Tạo một đối tượng HashMap lữu trữ mã số nhân viên và tiền lương.
       // String key: Mã số nhân viên
       // Float value: Tiền lương.
       HashMap<String, Float> salaryMap = new HashMap<String, Float>();
    
 
       salaryMap.put("E01", 1000f);
       salaryMap.put("E02", 12000f);
       salaryMap.put("E03", 12300f);
       salaryMap.put("E04", 1000f);
       salaryMap.put("E05", 300.5f);
        
       // Lấy ra tiền lương của nhân viên 'E02'
       Float salary= salaryMap.get("E02");
       System.out.println("Salary of employee E02 = "+ salary);
        
       // Thay đổi tiền lương cho nhân viên 'E05'
       salaryMap.put("E05", 400f);
        
       System.out.println("Salary of employee E05 = "+ salaryMap.get("E05"));
    }
}

/*
HashMap là một đối tượng chứa các cặp khóa và giá trị (Key-Value). 
Chẳng hạn như một danh bạ điện thoại, trong đó số điện thoại là khóa, 
còn thông tin chủ thuê bao là giá trị. Các khóa thì không được trùng nhau.
*/