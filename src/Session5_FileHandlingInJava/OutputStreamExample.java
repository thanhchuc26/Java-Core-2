/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author June
 */
public class OutputStreamExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
        // Tạo một luồng ký tự đầu ra với mục đích ghi thông tin vào file
        try (OutputStream myOutputStream = new FileOutputStream("d:/session05/OutputStream.txt")) {
            // Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
            byte[] myByte = new byte[]{'H', 'e', 'l', 'l', 'o'};
            // Ghi lần lượt các ký tự vào luồng
            for (int i = 0; i < myByte.length; i++) {
                // Ghi ký tự vào luồng
                myOutputStream.write(myByte[i]);
            }
            // Đóng luồng đầu ra lại khi việc ghi xuống file hoàn tất.
            myOutputStream.close();
        }
        System.out.println("Done");
    }

}

/*
Class OutputStream (luồng nhị phân) là một class trìu tượng vì vậy bạn không thể khởi tạo đối tượng OutputStream thông qua chính class OutputStream .
Tuy nhiên class này rẽ ra nhiều nhánh thông qua các class con thừa kế nó và quan trọng .
Tùy vào các tình huống bạn có thể tạo đối tượng InputStream từ cấu tử của các class con.
 */
