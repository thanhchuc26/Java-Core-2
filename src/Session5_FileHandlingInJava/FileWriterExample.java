/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author June
 */
public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String data = "Cộng hòa xã hội chủ nghĩa việt nam";
        File file = new File("d:/session05/FileWriter.txt");
        if (!file.exists()) {
           file.createNewFile();
        }
//        BufferedWriter bw = new BufferedWriter(fw);
        try (FileWriter fw = new FileWriter(file, false)) { //true: ghi thêm vào cuối file. flase: ghi đè lên nội dung cũ
            fw.write(data);
            fw.flush();
            fw.close();
        }
        System.out.println("Done");
    }
}

/*
FileReader và FileWriter chỉ để đọc và ghi file chứa dữ liệu văn bản, 
không dùng để đọc và ghi định dạng file hình ảnh, video như (.jpg, .png, .mp4 v..v..).
*/