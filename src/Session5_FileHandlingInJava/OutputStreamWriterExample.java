/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 *
 * @author June
 */
public class OutputStreamWriterExample {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        // Tạo một luồng nhị phân, ghi file.
        OutputStream out = new FileOutputStream("d:/session05/OutputStreamWriter.txt");

        // Tạo một luồng ký tự từ luồng nhị phân.
        // Mã hóa ghi UTF-16
        Writer writer = new OutputStreamWriter(out, "UTF-16");
        String str = "cộng hòa xã hội chủ nghĩa Việt Nam";
        str += "\r\n";
        str += "Độc lập - Tự do - Hạnh phúc";
        writer.write(str);
        writer.flush();;
        writer.close();
    }

}
