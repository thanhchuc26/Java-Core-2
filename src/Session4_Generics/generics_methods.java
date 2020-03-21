/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session4_Generics;

/**
 *
 * @author June
 */
public class generics_methods {

    public static <mang> void inMang(mang[] mangcanin) {
        for (mang phantumang : mangcanin) {
            System.out.print(phantumang + " ");
        }
        System.out.println("");
    }

    public static void inMang1(Integer[] mang) {
        for (Integer mang1 : mang) {
            System.out.print(mang1 + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] mangInteger = {1, 2, 3, 4, 5};
        inMang(mangInteger);
        Double[] mangDouble = {1.1, 2.2, 3.3, 4.4};
        inMang(mangDouble);
//        Integer[] mangInteger1 = {1, 2, 3};
//        inMang1(mangInteger1);
//        Double[] mangDouble1 = {1.1, 2.2, 3.3};
//        inMang1(mangDouble1);
    }
}
