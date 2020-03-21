/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_ExceptionsAndAssertions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author June
 */
public class try_with_resources {

    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//resource 
            return br.readLine();
        }
    }

    public static void main(String[] args) {

    }
}

//Kể từ Java 7 trở đi, chúng ta có thêm một tùy chọn mới đó là try-with-resources. 
//Nó được sử dụng cho các trường hợp là đối tượng của interface Closeable resouces 
//ví như là streams chẳng hạn.
//Câu lệnh try­with­resources là câu lệnh try dùng để khai báo một hoặc nhiều tài nguyên.
//Một tài nguyên là một đối tượng trong đó phải được đóng sau khi chương trình kết thúc với nó.
//Câu lệnh try­with­resources đảm bảo rằng mỗi tài nguyên sẽ được đóng ngay khi kết thúc câu
//lệnh. Bất kỳ đối tượng nào thực thi java.lang.AutoCloseable, bao gồm cả những đối tượng thực
//thi java.io.Closeable, thì đều được sử dụng như là một nguồn tài nguyên.
//Ví dụ dưới đây đọc dòng đầu tiên từ một tập tin. Nó sử dụng một thể hiện
//của BufferedReader để đọc dữ liệu từ tập tin. BufferedReader là một tài nguyên và phải được
//đóng sau khi chương trình kết thúc với nó.
//Trong ví dụ ở dưới, tài nguyên được khai báo trong try­with­resources là một BufferedReader.
//Câu lệnh khai báo xuất hiện trong ngoặc đơn ngay sau từ khóa try. Lớp BufferedReader, từ
//bản Java SE 7, sẽ thực thi giao diện java.lang.AutoCloseable. Vì thể hiện
//của BufferedReader được khai báo trong try­with­resources, nên nó sẽ đóng bất kể là câu
//lệnh try hoàn thành một cách bình thường hay đột ngột (như là kết quả của phương thức
//BufferedReader.readLine ném ngoại lệ IOException).
//Trước Java SE 7, bạn có thể sử dụng khối finally để thực hiện điều trên. Ví dụ sau đây sử dụng
//khối finally thay vì câu lệnh try­with­resources:
//static String readFirstLineFromFileWithFinallyBlock(String path) throws
//IOException {
//BufferedReader br = new BufferedReader(new FileReader(path));
//try {
//return br.readLine();
//} finally {
//if (br != null) br.close();
//}
//}
//Tuy nhiên, trong ví dụ trên, nếu các phương thức readLine và close đều ném ngoại lệ, thì
//phương thức readFirstLineFromFileWithFinallyBlock sẽ ném ngoại lệ được ném từ khối finally;
//ngoại lệ được ném từ khối try sẽ bị bỏ qua. Ngược lại, trong ví dụ nằm trên ví dụ này thì
//ở phương thức readFirstLineFromFile, nếu ngoại lệ được ném ra từ cả hai khối try và try­withresources
//thì phương thức readFirstLineFromFile sẽ ném ngoại lệ được ném từ khối try; ngoại
//lệ được ném từ khối try­with­resources sẽ bị bỏ qua. Từ bản Java SE 7 thì bạn có thể truy xuất
//các ngoại lệ bị bỏ qua, xin xem thêm tại phần Ngoại lệ bị bỏ qua.
//Bạn có thể khai báo một hoặc nhiều tài nguyên trong câu lệnh try­with­resources. Ví dụ sau lấy
//tên của các tập tin được đóng gói trong file zip là zipFileName và tạo ra một tập tin văn bản có
//chứa tên của các tập tin này:
//public static void writeToFileZipFileContents(String zipFileName, String
//outputFileName) throws java.io.IOException {
//java.nio.charset.Charset charset =
//java.nio.charset.StandardCharsets.US_ASCII;
//java.nio.file.Path outputFilePath =
//java.nio.file.Paths.get(outputFileName);
//// Mở file zip và tạo đầu ra với
//// câu lệnh try­with­resources
//try (
//java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
//java.io.BufferedWriter writer
//= java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
//) {
//// Liệt kê từng mục
//for (java.util.Enumeration entries = zf.entries();
//entries.hasMoreElements();) {
//// Lấy tên đầu vào và ghi nó tới tập tin đầu ra
//String newLine = System.getProperty("line.separator");
//String zipEntryName
//= ((java.util.zip.ZipEntry)entries.nextElement()).getName() + newLine;
//writer.write(zipEntryName, 0, zipEntryName.length());
//}
//}
//}
//Trong ví dụ trên, câu lệnh try­with­resources chứa hai khai báo được phân cách bằng dấu chấm
//phẩy: ZipFile và BufferedWriter. Khi các khối mã trực tiếp sau nó chấm dứt hoặc là bình
//thường hoặc phát sinh ngoại lệ, thì các phương thức close của các đối
//tượng BufferedWriter và ZipFile được tự động gọi theo thứ tự này. Lưu ý rằng các phương
//thức close của các nguồn tài nguyên được gọi theo thứ tự ngược.
//Lưu ý: Mỗi câu lệnh try­with­resources có thể có các khối catch và finally giống như câu
//lệnh try thông thường. Trong try­with­resources thì bất kỳ khối catch hay finally nào chạy sau
//các tài nguyên được khai báo thì đều bị đóng.
//Ngoại lệ bị bỏ qua:
//Một ngoại lệ có thể được ném ra từ khối mã lệnh kết hợp với câu lệnh try­withresources.
//Trong ví dụ writeToFileZipFileContents, một ngoại lệ có thể được ném từ khối try, và
//có thể lên đến hai ngoại lệ được ném từ try­with­resources khi nó cố đóng các đối
//tượng ZipFile và BufferedWriter. Nếu một ngoại lệ được ném từ khối try và một hoặc nhiều
//ngoại lệ được ném từ khối try­with­resources thì những ngoại lệ ném từ try­with­resources sẽ
//bị bỏ qua, và ngoại lệ được ném bởi khối là ngoại lệ được ném bởi phương
//thức writeToFileZipFileContents. Bạn có thể lấy những ngoại lệ bị bỏ qua này bằng cách gọi
//phương thức Throwable.getSuppressed từ ngoại lệ được ném ra bởi khối try.
