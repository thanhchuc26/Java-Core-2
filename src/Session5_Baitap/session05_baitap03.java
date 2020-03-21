/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_Baitap;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class session05_baitap03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao mot duong dan thu muc: ");
        String path = input.nextLine();
        System.out.print("Nhap vao mot so nguyen n(KB): ");
        int n = input.nextInt();
        File myFile = new File(path);
        System.out.printf("Cac file co kich thuoc lon hon %,d(KB):\n",n);
        String[] listFile = myFile.list();
        for (String i : listFile) {
            myFile = new File(path, i);
            if (myFile.isFile()) {
                if ((myFile.length() / 1024) > n) {
                    System.out.println(myFile.getName());
                }
            }
        }
    }
}
