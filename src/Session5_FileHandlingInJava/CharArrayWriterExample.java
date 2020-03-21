/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author June
 */
public class CharArrayWriterExample {

    public static void main(String[] args) throws IOException {
        char c[] = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
       CharArrayWriter out = new CharArrayWriter();
       // Ghi dữ liệu vào luồng 'out'
       out.write(c);
 
       FileWriter f1 = new FileWriter("d:/session05/CharArrayWriter1.txt");
       // Ghi dữ liệu từ CharArrayWriter vào FileWriter f1
       out.writeTo(f1);
 
       FileWriter f2 = new FileWriter("d:/session05/CharArrayWriter2.txt");
       // Ghi dữ liệu từ CharArrayWriter vào FileWriter f2
       out.writeTo(f2);
 
       f1.close();
       f2.close();
 
       // Đóng luồng CharArrayWriter 'out'.
       out.close();
 
       FileWriter f3 = new FileWriter("d:/session05/CharArrayWriter3.txt");
       // Với CharArrayWriter, sau khi đóng luồng
       // Không có ngoại lệ ném ra, nhưng writeTo(..) ko có tác dụng.
       out.writeTo(f3);
 
       System.out.println("Done");
    }
}

/*
CharArrayReader và CharArrayWriter cũng tương tự như các lớp ByteArrayInputStream và ByteArrayOutputStream 
ở chổ chúng hỗ trợ nhập/xuất từ các vùng đệm. 
Các lớp CharArrayReader và CharArrayWriter hỗ trợ nhập/ xuất ký tự 8 bit.

CharArrayReader không bổ sung thêm phương pháp nào, nó chỉ dùng các phương thức mà lớp Reader cung cấp. 

CharArrayWriter bổ sung thêm các phương thức sau đây ngoài các phương thức của lớp Writer.
reset( ): Thiết lập lại vùng đệm
size( ): trả về kích cỡ hiện hành của vùng đệm
toCharArray( ): Trả về bản sao mảng ký tự của vùng đệm xuất
toString( ): Chuyển đổi vùng đệm xuất thành một đối tượng String
writeTo( ): Ghi vùng đệm ra một luồng xuất khác.
*/
