/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 *
 * @author June
 */
public class ObjectInputStreamExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Tạo một luồng đọc file..
        FileInputStream fis = new FileInputStream("d:/session05/ObjectOutputStream.txt");

        // Tạo đối tượng ObjectInputStream bao lấy 'fis'.
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Đọc ra đối tượng String:
        String s = ois.readUTF();

        System.out.println(s);

        // Đọc ra đối tượng Date.
        Date date = (Date) ois.readObject();
        System.out.println("Date = " + date);

        Student student1 = (Student) ois.readObject();

        System.out.println("Student " + student1.getFirstName());

        Pupil pupil = (Pupil) ois.readObject();

        System.out.println("Pupil " + pupil.getFullName());

        Student student2 = (Student) ois.readObject();

        System.out.println("Student " + student2.getFirstName());

        ois.close();
    }
}

/*
ObjectInputStream, ObjectOutputStream cho phép bạn đọc hoặc ghi một Object vào luồng. 
Các Object này phải là kiểu Serializable (Nghĩa là có thể sắp hàng).
*/
