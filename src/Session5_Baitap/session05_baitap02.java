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
public class session05_baitap02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao mot duong dan thu muc: ");
        String path = input.nextLine();
        File myFile = new File(path);
        boolean check = false;
        String[] listFile = myFile.list();
        for (String i : listFile) {
            if (i.endsWith(".java")) {
                check = true;
            }
        }
        if (!check) {
            System.out.println("Thu muc nay khong co cac file co phan mo rong la .java");
        } else {
            System.out.println("Cac file co phan mo rong la .java:");
            for (String i : listFile) {
                if (i.endsWith(".java")) {
                    myFile = new File(path, i);
                    if (myFile.isFile()) {
                        System.out.println(myFile.getName());
                    }
                }
            }
        }
    }
}
