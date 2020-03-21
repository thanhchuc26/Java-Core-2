/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author June
 */
public class FileOutputStreamExample {
    public static void main(String[] args) {
        FileOutputStream fop = null;
        File file;
        String content = "This is new content.";
  
        try {
  
            file = new File("d:/session05/FileOutputStream.txt");
            fop = new FileOutputStream(file);
  
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
  
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();
  
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
  
            System.out.println("Done");
  
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
FileOutputStream là một lớp bytes stream được sử dụng để xử lý các dữ liệu nhị phân. 
Để ghi dữ liệu vào tập tin, bạn phải chuyển đổi các dữ liệu vào byte và lưu nó vào tập tin
*/