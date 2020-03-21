/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;

/**
 *
 * @author June
 */
public class DeflaterOutputStream_Class {

    public static void main(String[] args) {
        try {
            File filein = new File("d:/session06/session06.txt");
            FileInputStream finRead = new FileInputStream(filein);
            File fileout = new File("d:/session06/DeflaterOutputStream.txt");
            FileOutputStream foutWrite = new FileOutputStream(fileout);
            DeflaterOutputStream deflWrite = new DeflaterOutputStream(foutWrite);
            System.out.println("Original file size " + filein.length());
// Đọc và ghi dữ liệu đã nén
            int bread = 0;
            while ((bread = finRead.read()) != -1) {
                deflWrite.write(bread);
            }
// Đóng các đối tượng
            deflWrite.close();
            finRead.close();
            System.out.println("File size after compression " + fileout.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Phân tích: Trong đoạn mã, hai đối tượng File được tạo là filein và fileout, trong
đó filein mang vị trí của tập tin nguồn và fileout và vị trí của tập tin đã nén. Đối
tượng filein được truyền như là một tham chiếu tới FileInputStream và đối tượng fileout được
truyền như là một tham chiếu tới FileOutputStream. Đối tượng DeflaterOutputStream đọc tập
tin Hello.txt và nén nó lại. Cuối cùng, đối tượng FileInputStream có tên finRead gọi phương
thức write() để ghi dữ liệu đã nén tới tập tin đầu ra có tên DeflatedMain.dfl.
*/

/*
DeflaterOutputStream Class:
Lớp DeflaterOutputStream đọc dữ liệu nguồn, nén nó theo định dạng nén 'deflate' và sau đó
ghi dữ liệu đã nén tới luồng xuất đã định nghĩa trước đó. Nó cũng đóng vai trò như là cơ sở cho
những loại bộ lọc nén khác như GZIPOutputStream.
Cú pháp:
public DeflaterOutputStream(OutputStream in) : Hàm tạo này tạo một luồng xuất các
byte để ghi dữ liệu đã nén với kích thước bộ nén và bộ đệm mặc định

Các phương thức của lớp DeflaterOutputStream:
write(int buffer): Ghi một byte của dữ liệu đã nén tới luồng xuất.

write(byte[] buffer, int offset, int buffSize): Ghi một mảng byte dữ liệu đã nén tới luồng xuất. 
Ở đây, buffer là dữ liệu đầu vào được ghi thành các byte,, offset là vị trí bắt đầu của dữ liệu đầu vào,
và buffSize là kích thức của buffer.

deflate(): Nén dữ liệu nguồn và ghi khối dữ liệu đã nén tiếp theo tới luồng xuất.
close(): Đóng luồng xuất sau khi ghi phần dữ liệu đã nén còn lại.
finish(): Hoàn thành tiến trình ghi dữ liệu đã nén tới luồng xuất nhưng không đóng nó.
*/