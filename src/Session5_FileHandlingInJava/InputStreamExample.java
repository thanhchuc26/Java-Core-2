/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author June
 */
public class InputStreamExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Tạo một đối tượng InputStream theo class con của nó.
        // Đây là luồng đọc một file.
        InputStream myInputStream = new FileInputStream("d:/session05/OutputStream.txt");
        int i = -1;
        // Đọc lần lượt các byte trong luồng.
        // Mỗi lần đọc ra 8bit, chuyển nó thành số int.
        // Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
        while ((i = myInputStream.read()) != -1) {
            System.out.println(i + " " + (char) i);
        }
        // Đóng luồng đầu vào lại khi việc đọc file hoàn tất.
        
        myInputStream.close();
        
    }
}

/*
Class OutputStream (luồng nhị phân) là một class trìu tượng vì vậy bạn không thể khởi tạo đối tượng OutputStream thông qua chính class OutputStream .
Tuy nhiên class này rẽ ra nhiều nhánh thông qua các class con thừa kế nó và quan trọng .
Tùy vào các tình huống bạn có thể tạo đối tượng InputStream từ cấu tử của các class con.
*/
