/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 *
 * @author June
 */
public class CharArrayReaderExample {
    public static void main(String[] args) throws IOException {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        int length = tmp.length();
        char c[] = new char[length];
        tmp.getChars(0, length, c, 0);

        CharArrayReader input1 = new CharArrayReader(c);
        CharArrayReader input2 = new CharArrayReader(c, 0, 5);
        int i;
        System.out.print("input1 is:");
        while ((i = input1.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
        System.out.print("input2 is:");
        while ((i = input2.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
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