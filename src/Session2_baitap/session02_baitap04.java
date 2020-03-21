/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_baitap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author June
 */
class class1 {

    private String nameClass1;

    void displayClass1() {
        System.out.println(this.nameClass1);
    }
}

class class2 {

    static void getFieldsClass1() {
        Field[] fieldsClass1 = class1.class.getDeclaredFields();
        System.out.print("Class1 có các thuộc tính sau: ");
        for (Field i : fieldsClass1) {
            System.out.print(i.getName() + " ");
        }
    }

    static void getMethodsClass1() {
        Method[] methodsClass1 = class1.class.getMethods();
        System.out.print("Class1 có các phương thức sau: ");
        for (Method i : methodsClass1) {
            System.out.print(i.getName() + " ");
        }
    }

    static void changeFiledsClass1() throws InstantiationException, IllegalAccessException {
        class1 obj1 = new class1();
        Class<?> myClass = obj1.getClass();
        class1 obj2 = (class1) myClass.newInstance();
        Field[] fieldsClass1 = class1.class.getDeclaredFields();
        for (Field field : fieldsClass1) {
            field.setAccessible(true);
            if (field.getName().equals("nameClass1")) {
                field.set(obj2, "obj2");
            }
        }
        System.out.print("Gía trị thuộc tính sau khi thay đổi là: ");
        obj2.displayClass1();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        getFieldsClass1();
//        getMethodsClass1();
        changeFiledsClass1();
    }
}

public class session02_baitap04 {

}
