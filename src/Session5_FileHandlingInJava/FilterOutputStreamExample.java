/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author June
 */
public class FilterOutputStreamExample {

    public static void main(String[] args) throws IOException {
        OutputStream OutputStreamObj = null;
        FilterOutputStream filterOutputStreamObj = null;
        FileInputStream filterInputStreamObj = null;
        byte[] bufObj = {65, 66, 67, 68, 69};
        int i = 0;
        char c;
//encloses the creation of stream objects within try-catch block
        try {
// creates output stream objects
            OutputStreamObj = new FileOutputStream("d:/session05/test.txt");
            filterOutputStreamObj = new FilterOutputStream(OutputStreamObj);
// writes to the output stream from bufObj
            filterOutputStreamObj.write(bufObj);
// forces the byte contents to be written to the stream
            filterOutputStreamObj.flush();
// creates an input stream object
            filterInputStreamObj = new FileInputStream("d:/session05/test.txt");
            while ((i = filterInputStreamObj.read()) != -1) { // converts integer to character
                c = (char) i;
// prints the character read
                System.out.println("Character read after conversion is: " + c);
            }
        } catch (IOException e) {
// checks for any I/O errors
            System.out.print("Close() is invoked prior to write()");
        } finally {
// releases system resources associated with the stream
            if (OutputStreamObj != null) {
                OutputStreamObj.close();
            }
            if (filterOutputStreamObj != null) {
                filterOutputStreamObj.close();
            }
        }
    }
}

/*
Lớp FilterOutputStream trong java extends lớp OutputStream. Nó cung cấp các lớp con khác nhau như BufferedOutputStream và DataOutputStream để cung cấp các chức năng bổ sung. Vì vậy, nó ít được sử dụng riêng lẻ.
*/