/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author June
 */
public class BufferedInputStreamExample {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInput = new BufferedInputStream(new FileInputStream("d:/session05/BufferedOutputStream.txt"));

        int ch = 0;
        while ((ch = bufferedInput.read()) != -1) {
            System.out.print((char) ch);
        }
        bufferedInput.close();
        System.out.println("");
    }
}

/*
Việc truy xuất tập tin trực tiếp trên đĩa hay trên mạng có thể gây ra chậm chạp, do mỗi lần ta thực hiện thao tác ghi hay đọc một ký tự từ tập tin, chương trình lại phải dò tìm trên đĩa. 
Có một cơ chế khác nhanh hơn là sử dụng bộ đệm. 

BufferedInputStream: Thường thì việc sử dụng bộ đệm chủ yếu dành cho các thao tác đối với tập tin, 
nhưng ta vẫn có thể dùng nó với bất kỳ luồng con nào khác được dẫn xuất từ lớp InputStream bởi BufferedInputStream là một lớp luồng trung gian.
*/
