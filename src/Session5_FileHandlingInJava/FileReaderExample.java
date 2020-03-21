/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author June
 */
public class FileReaderExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("d:/session05/FileWriter.txt");
        FileReader fr = new FileReader(file); 
      char [] a = new char[50];
      fr.read(a); // doc noi dung toi mang
      for(char c : a)
          System.out.print(c); //in tung ky tu mot
      fr.close();
        System.out.println("");
    }
}

/*
FileReader và FileWriter chỉ để đọc và ghi file chứa dữ liệu văn bản, 
không dùng để đọc và ghi định dạng file hình ảnh, video như (.jpg, .png, .mp4 v..v..).
*/