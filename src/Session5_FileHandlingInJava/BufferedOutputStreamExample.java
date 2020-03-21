/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author June
 */
public class BufferedOutputStreamExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream("d:/session05/BufferedOutputStream.txt"));
        // Start writing to the output stream
        bufferedOutput.write("Line one".getBytes());
        bufferedOutput.write("\n".getBytes()); // new line, you might want
        // to use \r\n if you're on
        // Windows
        bufferedOutput.write("Line two".getBytes());
        bufferedOutput.write("\n".getBytes());

        // prints the character that has the decimal value of 65
        bufferedOutput.write(65);
        bufferedOutput.flush();
        bufferedOutput.close();
    }
}

/*
Việc truy xuất tập tin trực tiếp trên đĩa hay trên mạng có thể gây ra chậm chạp, 
do mỗi lần ta thực hiện thao tác ghi hay đọc một ký tự từ tập tin, 
chương trình lại phải dò tìm trên đĩa. 
Có một cơ chế khác nhanh hơn là sử dụng bộ đệm. 

BufferedOutputStream: Ngược với quá trình đọc dữ liệu từ tập tin lên, quá trình ghi dữ liệu xuống tập tin cũng vậy, 
nếu ta cứ ghi liên tục từng ký tự một xuống tập tin vậy lý trên đĩa thì sẽ tỏ ra chậm chạp. 
Java cung cấp cơ chế ghi vào bộ đệm, ta chỉ việc kết nối tập tin với luồng BufferedOutputStream.

Tuy nhiên, không phải cứ ghi vào bộ đệm là dữ liệu được an toàn nằm trên tập tin mà phải mất một thời gian. 
Do đó nếu muốn chắc chắn thì phải gọi thêm phương thức flush().
 */
