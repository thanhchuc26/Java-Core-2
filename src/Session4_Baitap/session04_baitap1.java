/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session4_Baitap;

/**
 *
 * @author June
 */
class classAllType<Type> {

    private Type type;

    public classAllType() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}

public class session04_baitap1 {

    static void classInteger() {
        System.out.println("Tạo một class có kiểu Integer và gán giá trị 1 cho thuộc tính");
        classAllType<Integer> classInteger = new classAllType<>();
        classInteger.setType(1);
        System.out.println("Giá trị thuộc tính của class Integer là: " + classInteger.getType());
    }

    static void classString() {
        System.out.println("Tạo một class có kiểu String và gán giá trị \"classString\" cho thuộc tính");
        classAllType<String> classString = new classAllType<>();
        classString.setType("classString");
        System.out.println("Giá trị thuộc tính của class Integer là: " + classString.getType());
    }

    public static void main(String[] args) {
        classInteger();
        System.out.println("");
        classString();
    }

}
