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
public class session05_baitap01 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Nhap vao mot duong dan bat ky: ");
        String path=input.nextLine();
        File myFile=new File(path);
        if(myFile.exists()){
            if(myFile.isDirectory()){
                System.out.println("Duong dan vua nhap vao la mot thu muc");
            }
            else{
                System.out.println("Duong dan vua nhap vao la duong dan den mot file");
            }
        }
        else{
            System.out.println("Duong dan vua nhap vao khong ton tai!");
        }
    }
}
