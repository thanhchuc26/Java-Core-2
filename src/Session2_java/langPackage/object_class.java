/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.util.ArrayList;

/**
 *
 * @author June
 */
class Person {

}

class GiaoVien extends Person {

}

class SinhVien extends Person {

}

public class object_class implements Cloneable {

    String name;
    ArrayList<Person> listPerson;

    public object_class() {
        listPerson = new ArrayList<>();
    }

    static void cloneExample() throws CloneNotSupportedException {

        object_class object1 = new object_class();
        object1.name = "object_class";
        object_class object2 = (object_class) object1.clone();
        System.out.println("object1.name: " + object1.name);
        System.out.println("object2.name: " + object2.name);

        /*
    Nhân bản đối tượng là một cách để tạo một bản sao của một đối tượng. 
    Để thực hiện mục đích này, bạn sử dụng phương thức clone(). 
    Java.lang.Cloneable Interface phải được triển khai bởi lớp mà có đối tượng cần nhân bản chúng ta muốn tạo. 
    Nếu bạn không triển khai Cloneable Interface, phương thức clone() sẽ tạo CloneNoSupportedException.
    
    Tại sao sử dụng phương thức clone() trong Java?
    Phương thức clone() tiết kiệm các tiến trình xử lý phụ để tạo bản nhân bản của một đối tượng. 
    Nếu bạn thực hiện nó bởi từ khóa new, điều này sẽ tốn nhiều tiến trình xử lý hơn, 
    và đó là lý do tại sao chúng ta sử dụng nhân bản đối tượng.
         */
    }

    static void equalsExample() {
        object_class object1 = new object_class();
        object_class object2 = new object_class();
        object2 = object1;
        System.out.println(object1.equals(object2));

        /*
    equals là phương thức mặc định cho mọi class trong java (nó thuộc về class Object, 
    mà tất cả các class khác đều là con của Object, nên các class khác "kế thừa"). 
    equals ở đây phải hiểu theo "đối tượng", chứ không nên hiểu theo "nội dung". 
    Nó so sánh là so sánh địa chỉ tham chiếu của đối tượng, chứ ko phải là nội dung của đối tượng.
         */
    }

    static void getClassExample() {
        object_class object = new object_class();
        Person person = new Person();
        GiaoVien giaovien = new GiaoVien();
        SinhVien sinhvien = new SinhVien();
        object.listPerson.add(person);
        object.listPerson.add(giaovien);
        object.listPerson.add(sinhvien);
        System.out.println(object.listPerson.get(0).getClass().getName());
        System.out.println(object.listPerson.get(1).getClass().getName());

        /*
        getClass() trả về tên đầy đủ của class mô tả cho đối tượng bao gồm tên class và tên package. 
         */
    }

    static void hashCodeExample() {

        object_class object1 = new object_class();
        object_class object2 = new object_class();
        System.out.println("hashCode của object1 trước khi gán object1=object2: " + object1.hashCode());
        System.out.println("hashCode của object2 trước khi gán object1=object2: " + object2.hashCode());
        object1 = object2;
        System.out.println("hashCode của object1 sau khi gán object1=object2: " + object1.hashCode());
        System.out.println("hashCode của object2 sau khi gán object1=object2: " + object2.hashCode());
        /*
    Trong bộ nhớ, Java quản lí đối tượng theo mã băm (hashCode), có nghĩa là: 
    địa chỉ bộ nhớ các đối tượng sẽ được “băm” (hash) theo một công thức nào đó, 
    trở thành một số int duy nhất, không trùng lặp khi trên cùng 1 máy tính.
    
    hashCode có thể hiểu là giá trị định danh cho 1 đối tượng, 
    những đối tượng bằng nhau sẽ có hashCode bằng nhau 
    còn hashCode bằng nhau thì chưa chắc 2 đối tượng đó đã bằng nhau (đối với trường hợp kế thừa).
         */
    }

    public static void main(String[] args) throws CloneNotSupportedException {

//        cloneExample();
//        equalsExample();
        getClassExample();
//        hashCodeExample();
    }
}
