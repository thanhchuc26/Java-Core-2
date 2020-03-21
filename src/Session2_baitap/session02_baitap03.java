/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_baitap;

/**
 *
 * @author June
 */
public class session02_baitap03 {

    String name;

    public session02_baitap03(String name) {
        this.name = name;
    }

    static void sosanh3(session02_baitap03 obj1, session02_baitap03 obj2) {
        //gia tri bang nhau, dia chi bang nhau
        //gia tri bang nhau, dia chi ko bang nhau
        //gia tri ko bang nhau, dia chi bang nhau
        if (obj1.name.equalsIgnoreCase(obj2.name)) {
            if(obj1.hashCode()==obj2.hashCode()){
                System.out.println("Các giá trị thuộc tính và địa chỉ được cấp phát của 2 đối tượng bằng nhau");
            }
            else{
                System.out.println("Các giá trị thuộc tính của 2 đối tượng bằng nhau và địa chỉ được cấp phát của 2 đối tượng không bằng nhau");
            }
        } else {
            if(obj1.hashCode()==obj2.hashCode()){
                System.out.println("Các giá trị thuộc tính của 2 đối tượng không bằng nhau và địa chỉ được cấp phát của 2 đối tượng bằng nhau");
            }
            else{
                System.out.println("Các giá trị thuộc tính và địa chỉ được cấp phát của 2 đối tượng không bằng nhau");
            }
        }
    }

    public static void main(String[] args) {
        session02_baitap03 obj1 = new session02_baitap03("object1");
        session02_baitap03 obj2 = new session02_baitap03("object2");
//        obj1=obj2;
        sosanh3(obj1, obj2);
    }
}
