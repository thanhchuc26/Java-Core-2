/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterInputStream;

/**
 *
 * @author June
 */
public class DeflaterInputStream_Class {

    public static byte[] increaseArray(byte[] arrtemp) {

        byte[] temp = arrtemp;
        arrtemp = new byte[arrtemp.length + 1];
// Lưu trữ dữ liệu
        for (int itr = 0; itr < temp.length; itr++) {
            arrtemp[itr] = temp[itr];
        }
        return arrtemp;
    }

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        try {
            File file = new File("d:/session06/session06.txt");
            FileInputStream fis = new FileInputStream(file);
            DeflaterInputStream dis = new DeflaterInputStream(fis);
// Tạo mảng byte để nén dữ liệu
            byte input[] = new byte[0];
            int iindex = -1;
// đọc dữ liệu từ file
            int iread = 0;
            while ((iread = dis.read()) != -1) {
                input = increaseArray(input);
                input[++iindex] = (byte) iread;
            }
            fos = new FileOutputStream("d:/session06/DeflaterInputStream.txt");
            fos.write(input, 0, input.length);
            fos.close();
            System.out.println("File size after compression " + input.length);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeflaterInputStream_Class.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
            }
        }
    }
}

/*
Phân tích đoạn mã: Phương thức increaseArray() trong đoạn mã trên tạo một mảng động để
lưu trữ kích thước của tập tin đã nén. Đường dẫn của tập tin nguồn được xác định như một đối
số của thể hiện của lớp File. Đối tượng File sau đó được truyền như là một tham số tới đối
tượng FileInputStream. Tiếp theo, đối tượng FileInputStream được truyền như là tham số tới
thể hiện DeflaterInputStream. Một mảng byte được tạo để lưu dữ liệu đã giải nén. Đối tượng
DeflaterInputStream gọi phương thức read() để đọc dữ liệu từ tập tin nguồn. Dữ liệu đã nén
được lưu vào bộ đệm input. Lớp FileOutputStream tạo một tập tin có
tên DeflatedMain.dfl và sau đó ghi dữ liệu đã nén vào nó.

*/

/*
DeflaterInputStream Class
Lớp DeflaterInputStream đọc dữ liệu nguồn từ một luồng nhập và sau đó nén thành định
dạng nén 'deflate'. Lớp này cung cấp các hàm tạo và phương thức của chính bản thân nó. Dưới
đây là danh sách các hàm tạo:
­ public DeflaterInputStream(InputStream in): Hàm tạo này tạo một luồng nhập các byte để
đọc dữ liệu nguồn với kích thước của bộ nén và bộ đệm mặc định.
­ DeflaterInputStream(InputStream in, Deflater defl) : Tạo một luồng nhập mới với kích thước
bộ đệm mặc định và bộ nén xác định.
­ DeflaterInputStream(InputStream in, Deflater defl, int bufLen) : Tạo một luồng nhập mới với
kích thước bộ đệm và bộ nén xác định.

Các phương thức của lớp DeflaterInputStream:
read(): Trả về một byte dữ liệu nén được đọc từ luồng nhập.
read(byte[] buffer, int offset, int buffSize) throws IOException: Trả về số byte dữ liệu đã nén 
được đọc vào mảng buffer, bắt đầu từ vị trí offset và có độ dài là buffSize.
close(): Đóng luồng nhập sau khi đọc dữ liệu nguồn còn lại.
boolean markSupported(): Trả về false. Đó là bởi vì luồng nhập không hỗ trợ các
phương thức mark() và reset().
int available(): Trả về 0 sau khi EOF được nhận diện, ngược lại trả về 1.
long skip(long n): Bỏ qua và hủy dữ liệu từ luồng nhập.
*/
