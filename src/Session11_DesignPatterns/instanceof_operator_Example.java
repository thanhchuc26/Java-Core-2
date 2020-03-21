/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

/**
 *
 * @author June
 */
class Person {

}

class Student extends Person {

}

class Animal {

}

public class instanceof_operator_Example {

    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();
        Animal animal = new Animal();
        System.out.println("person object is instanceof of class Person? " + (person instanceof Person));
        System.out.println("student object is instanceof of class Student? " + (student instanceof Student));
        System.out.println("student object is instanceof of class Person? " + (student instanceof Person));
        System.out.println("animal object is instanceof of class Animal? " + (animal instanceof Animal));
    }
}

/*
Toán tử instanceof trong Java được sử dụng để kiểm tra xem đối tượng có là instance của kiểu cụ thể: 
lớp hoặc lớp con hoặc interface hay không. 
Toán tử instanceof trong Java còn được biết đến như là toán tử so sánh kiểu 
bởi vì nó so sánh instance với kiểu. Nó trả về true hoặc false. 
Nếu chúng ta áp dụng toán tử instanceof với bất cứ biến nào mà có giá trị null, thì nó trả về false.
*/
