/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author June
 */
public class ByteArrayOutputStreamExample {

    public static void main(String[] args) {
        String content = "This is the text content";
//        Tạo đối tượng ByteArrayOutputStream
        // Đối tượng chứa bên trong nó một mảng các byte.
        // Khởi tạo mảng các byte 10 phần tử.
        // Nếu số phẩn tử ghi vào luồng nhiều hơn 10 mảng sẽ được thay thế bằng
        // mảng mới có nhiều phần tử hơn, và copy các phần tử mảng cũ sang.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        // Hiển thị kích thước của ByteArrayOutputStream trước khi gán giá trị
        System.out.println("Kich thuoc ByteArrayOutputStream truoc khi gan gia tri: " + byteArrayOutputStream.size());
//        Đọc từng ký tự trong content và viết vào byteArrayOutputStream
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            byteArrayOutputStream.write(c);
        }
        // Hiển thị kích thước của ByteArrayOutputStream sau khi gán giá trị
        System.out.println("Kich thuoc ByteArrayOutputStream sau khi gan gia tri: " + byteArrayOutputStream.size());
        FileOutputStream fileOutputStream = null;
        try {
//            Viết dữ liệu trong byteArrayOutputStream
//            ra file sử dụng phương thức writeTo()
            fileOutputStream = new FileOutputStream("d:/session05/ByteArrayOutput.txt");
            byteArrayOutputStream.writeTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
ByteArrayOutputStream là một lớp kế thừa từ lớp OutputStream, 
nó được dùng để ghi dữ liệu trong một mảng byte, vùng nhớ (buffer) dữ liệu sẽ tự động tăng khi chúng ta ghi dữ liệu vào.

ByteArrayInputStream và ByteArrayOutputStream là những subclass của InputStream và OutputStream tương ứng, 
nó giúp bạn có thể đọc và viết dữ liệu từ mảng byte như một stream. 
Có nghĩa là nó sẽ wrap mảng byte thành InputStream hoặc một OutputStream và ngược lại, 
có thể lấy được một mảng byte từ chúng sử dụng phương thức toByteArray().


 */
