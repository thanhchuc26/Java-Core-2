/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.util.zip.Deflater;

/**
 *
 * @author June
 */
public class Deflater_Class {

    public static void main(String[] args) throws Exception {
        String str = "Chuỗi cần nén";
        System.out.println("Chuỗi trước khi nén: " + str);
        // Mã hóa một chuỗi thành các byte
        byte[] inputDeflater = str.getBytes("UTF-8");
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
    }
}

/*
Phân tích đoan code trên: Chuỗi đầu vào được khởi tạo và mã hóa thành màng byte. Tiếp theo, nó tạo một đối
tượng của lớp Deflater trong đó gọi phương thức setInput() để thiết lập dữ liệu đầu vào cho
việc nén. Đối tượng Deflater sau đó gọi phương thức deflate() để nén chuỗi đầu vào. Sau khi
nén thì phương thức deflate() trả về số lượng byte của dữ liệu đã nén và được lưu vào một
biến nguyên. Sau đó giá trị được hiển thị. Phương thức này giúp lấy kích thước của tập tin đã
nén theo dạng byte.
 */
//CÁC CLASS TRONG java.util.zip
// CheckedInputStream: Duy trì việc kiểm tra dữ liệu đang được đọc
// CheckedOutputStream: Duy trì việc kiểm tra dữ liệu đang được ghi
// Deflater: Thực thi nhiệm vụ nén dữ liệu
// DeflaterInputStream: Đọc dữ liệu nguồn và nén nó theo định dạng nén "deflate"
// DeflaterOutputStream: Đọc dữ liệu nguồn, nén nó theo định dạng nén "deflate", sau đó ghi ra outputstream
// Inflater: Thực hiện nhiệm vụ giải nén
// InflaterInputStream: Đọc dữ liệu nguồn rồi giải nén theo định dạng "deflate"
// InflaterOutputStream: Đọc dữ liệu nguồn rồi giải nén theo định dạng "deflate", sau đó ghi ra luồng xuất
// ZipInputStream: Thực thi một bộ lọc luồng nhận để đọc các file theo định dạng tập tin ZIP.
//Hỗ trợ các đầu vào nén và giải nén
// ZipOutputStream: Đọc dữ liệu nguồn, nén theo định dạng ZIP và ghi ra luồng xuất


/*
Deflater class
Lớp này có nhiệm vụ nén dữ liệu hiện thời vào một luồng nhập. Nó nén dữ liệu sử dụng thư viện nén ZLIB.
Hàm tạo của lớp này được dùng để tạo thể hiện với mức nén mặc định.

deflate(byte[] buffer): Điền vào bộ đệm xuất các dữ liệu đã được nén và trả về kích thước thực
    của dữ liệu đó dưới dạng một số nguyên. 
 
deflate(byte[] buffer, int offset, int len): Điền vào bộ đệm xuất các dữ liệu đã được nén 
    và trả về kích thước thực của dữ liệu đó dưới dạng một số nguyên. Ở đây, tham số buffer là bộ đệm được
    dùng để lưu dữ liệu nén, offset là vị trí bắt đầu của dữ liệu, và len là số byte lớn nhất của dữ liệu nén.

setInput(byte[] buffer): Đặt dữ liệu nhập hiện thời vào bộ đệm để nén.
setInput(byte[] buffer, int offset, int len): Đặt dữ liệu nhập hiện thời vào bộ đệm để nén. 
    Ở đây, buffer là bộ đệm được dùng để lưu các byte dữ liệu đầu vào, offset là vị trí bắt đầu của dữ liệu, 
    và len là kích thước của dữ liệu.

finish(): Chỉ ra rằng quá trình nén nên được kết thúc với nội dung hiện thời của bộ đệm nhập.

end(): Đóng bộ nén và bỏ qua dữ liệu đầu vào không được xử lý.
*/
