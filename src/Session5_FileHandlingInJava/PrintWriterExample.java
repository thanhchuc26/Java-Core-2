/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author June
 */
public class PrintWriterExample {

    public static void main(String[] args) throws FileNotFoundException {
        // Dữ liệu được ghi trên Console sử dụng lớp PrintWriter
        PrintWriter writer = new PrintWriter(System.out);
        writer.write("VietTuts.Vn: ");
        writer.flush();
        writer.close();
        // Dữ liệu được ghi vào File sử dụng PrintWriter
        PrintWriter writer1 = null;
        writer1 = new PrintWriter(new File("D:/session05/testout.txt"));
        writer1.write("Java, Spring, Hibernate, Android, PHP, ...");
        writer1.flush();
        writer1.close();

    }
}

/*
Lớp PrintWriter trong java là bản cài đặt của lớp Writer. Nó được sử dụng để ghi các định dạng đại diện của các đối tượng vào stream hướng văn bản.
*/
