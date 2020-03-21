/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author June
 */
public class InputStreamWriterExample {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // Tạo một luồng nhị phân, đọc file.
       InputStream in = new FileInputStream("d:/session05/OutputStreamWriter.txt");
 
       // Tạo một luồng ký tự từ luồng nhị phân.
       // Mã hóa đọc UTF-8
       Reader reader = new InputStreamReader(in, "UTF-16");
 
       int i = 0;
       // Đọc lần lượt từng ký tự
       while ((i = reader.read()) != -1) {
           // Ép kiểu về ký tự và in ra màn hình
           System.out.print((char) i);
       }
       reader.close();
    }
}
