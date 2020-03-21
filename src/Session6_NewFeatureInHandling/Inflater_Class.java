/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 *
 * @author June
 */
public class Inflater_Class {

    public static void main(String[] args) throws Exception {
        String str = "Chuỗi cần nén";
        System.out.println("Chuỗi trước khi nén: " + str);
        // Mã hóa một chuỗi thành các byte
        byte[] inputDeflater = str.getBytes("UTF-16");
        // Nén các byte
        byte[] outputDeflater = new byte[100];
        Deflater myDeflater = new Deflater();
        myDeflater.setInput(inputDeflater);
        myDeflater.finish();
        myDeflater.deflate(outputDeflater);
        System.out.print("Chuỗi sau khi nén: ");
        for (int i = 0; i < outputDeflater.length; i++) {
            if (outputDeflater[i] != 0) {
                System.out.print(outputDeflater[i]);
            }
        }
        System.out.println("");

        // Giải nén các byte
        byte[] inputInflater = new byte[100];
        Inflater myInflater = new Inflater();
        myInflater.setInput(outputDeflater);
        myInflater.inflate(inputInflater);
        myInflater.end();
        // Giải mã các byte thành một chuỗi
        String resultInflater = new String(inputInflater, "UTF-16");
        System.out.println("Chuỗi sau khi giải nén: " + resultInflater);
    }

}

/*
Inflater Class
Lớp Inflater dùng để giải nén dữ liệu đã nén. Nó hỗ trợ việc giải nén sử dụng thư viện ZLIB.

inflate(byte[] buffer): Điền vào bộ đệm xuất dữ liệu đã giải nén và trả về một số nguyên là kích
thước thực của nó.

inflate(byte[] buffer, int offset, int len): Điền vào bộ đệm xuất dữ liệu đã giải nén và trả về một số nguyên 
là kích thước thực của nó. Ở đây, buffer là bộ đệm dùng để lưu dữ liệu đã giải nén,
offset là vị trí bắt đầu của dữ liệu, len là số byte lớn nhất của dữ liệu đã giải nén.

setInput(byte[] buffer): Đặt dữ liệu nhập hiện thời vào bộ đệm để giải nén.

setInput(byte[] buffer, int offset, int len): Đặt dữ liệu nhập hiện thời vào bộ đệm để giải nén. 
Ở đây, buffer là bộ đệm dùng để lưu các byte dữ liệu đã nén, offset là vị trí bắt đầu của dữ liệu, len là
độ dài của dữ liệu đã nén.
end(): Đóng bộ giải nén.

 */
