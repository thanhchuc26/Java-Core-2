/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author June
 */
class classCha {

    private String tenCha;
    private int tuoiCha;

    public String getTenCha() {
        return tenCha;
    }

    public int getTuoiCha() {
        return tuoiCha;
    }

    public void setTenCha(String tenCha) {
        this.tenCha = tenCha;
    }

    public void setTuoiCha(int tuoiCha) {
        this.tuoiCha = tuoiCha;
    }

}

class classCon {

    private String tenCon;
    private int tuoiCon;
}

public class class_class {

    static void forName() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("session02.class_class");
        class_class myObject = new class_class();
        System.out.println(myObject.getClass().getName());
    }

    static void getFieldsClassCha() {
        // lấy danh sách tất cả các thuộc tính của classCha
        Field[] fieldClassCha = classCha.class.getDeclaredFields();
        System.out.print("Các thuộc tính của classCha: ");
        for (Field i : fieldClassCha) {
            System.out.print(i.getName() + " ");
        }
        System.out.println("");
    }

    static void getMethodsClassCha() {
        // lấy danh sách tất cả các method của classCha
        Method[] methodClassCha = classCha.class.getMethods();
        System.out.print("Các method của classCha: ");
        for (Method i : methodClassCha) {
            System.out.print(i.getName() + " ");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        forName();
        getFieldsClassCha();
        getMethodsClassCha();

    }
}
