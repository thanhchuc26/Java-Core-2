/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author June
 */
class Student implements Serializable {
 
   private static final long serialVersionUID = -5074534753977873204L;
 
   private String firstName;
 
   private String lastName;
 
   public Student(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }
 
   public String getFirstName() {
       return firstName;
   }
 
   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }
 
   public String getLastName() {
       return lastName;
   }
 
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }
 
}

class Pupil implements Serializable {
  
   private static final long serialVersionUID = -8501383434011302991L;
    
   private String fullName;
 
   public Pupil(String fullName)  {
       this.fullName= fullName;
   }
    
   public String getFullName() {
       return fullName;
   }
 
   public void setFullName(String fullName) {
       this.fullName = fullName;
   }
 
}
public class ObjectOutputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
      // Tao mot luong ghi vào file ...
      FileOutputStream fos = new FileOutputStream("d:/session05/ObjectOutputStream.txt");
 
      // Tạo đối tượng ObjectOutputStream bao lấy 'fos'.
      // Những gì ghi vào luồng này sẽ được đẩy xuống 'fos'.
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      
      
      // Ghi một String vào luồng.
      oos.writeUTF("This is student, pupil profiles");
      
      // Chú ý: Các đối tượng ghi được vào luồng phải
      // là kiểu Serializable.
      
      // Ghi một đối tượng Date vào luồng.
      oos.writeObject(new Date());
 
      Student student1 = new Student("Nguyen", "Quan");
      Student student2 = new Student("Tran", "Hanh");
      Pupil pupil1 = new Pupil("Nguyen Van Ba");
 
      oos.writeObject(student1);
      oos.writeObject(pupil1);
      oos.writeObject(student2);
 
      oos.close();
      System.out.println("Write successful");
    }
}

/*
ObjectInputStream, ObjectOutputStream cho phép bạn đọc hoặc ghi một Object vào luồng. 
Các Object này phải là kiểu Serializable (Nghĩa là có thể sắp hàng).
*/
