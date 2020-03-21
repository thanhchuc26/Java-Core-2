/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

/**
 *
 * @author June
 */
public class split {

    public static void main(String[] args) {
        String str = "Toi la hoc vien Sotech.vn";
        String[] words = str.split("\\s");//chia chuoi dua tren string phan cac nhau boi khoang trang (\\s) 
//su dung vong lap foreach de in cac phan tu trong mang chuoi  
        for (String w : words) {
            System.out.println(w);
        }
    }
}
