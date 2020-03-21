/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author June
 */
public class ByteArrayInputStreamExample {

    public static void main(String[] args) throws IOException {
        FileInputStream myFileInputStream = new FileInputStream("d:/session05/ByteArrayOutput.txt");
        String content = "";
        int i = -1;
        while ((i = myFileInputStream.read()) != -1) {
            content += (char) i;
        }
        myFileInputStream.close();
        byte[] myByte=content.getBytes();
        ByteArrayInputStream myByteArrayInputStream=new ByteArrayInputStream(myByte);
        System.out.println("Kich thuoc cua ByteArrayInputStream: "+myByte.length);
        System.out.print("Noi dung cua ByteArrayInputStream: ");
        for (int j = 0; j < myByte.length; j++) {
            System.out.print((char)myByte[j]);
        }
        System.out.println("");
    }
}

/*
ByteArrayInputStream là lớp dùng để chứa những byte có thể được đọc bởi các stream khác, 
chúng ta có thể đọc từng ký tự hoặc nhiều ký tự từ stream này. CÒn nếu đọc từ ByteArrayOutputStream chúng ta chỉ có thể lấy ra một mảng byte.
FileInputStream dùng để đọc byte dữ liệu từ một tập tin trong ổ đĩa.

ByteArrayInputStream và ByteArrayOutputStream là những subclass của InputStream và OutputStream tương ứng, 
nó giúp bạn có thể đọc và viết dữ liệu từ mảng byte như một stream. 
Có nghĩa là nó sẽ wrap mảng byte thành InputStream hoặc một OutputStream và ngược lại, 
có thể lấy được một mảng byte từ chúng sử dụng phương thức toByteArray().
*/
