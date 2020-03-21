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
public class session02_baitap02 {

    static void sosanh2(session02_baitap02 obj1, session02_baitap02 obj2) {
        if (obj1.hashCode() == obj2.hashCode()) {
            System.out.println("Địa chỉ được cấp phát của 2 đối tượng bằng nhau");
        } else {
            System.out.println("Địa chỉ được cấp phát của 2 đối tượng không bằng nhau");
        }
    }

    public static void main(String[] args) {
        session02_baitap02 obj1 = new session02_baitap02();
        session02_baitap02 obj2 = new session02_baitap02();
//        obj1=obj2;
        sosanh2(obj1, obj2);
    }
}
