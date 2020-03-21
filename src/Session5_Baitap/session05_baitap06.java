/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_Baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class session05_baitap06 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        ArrayList<String> content = new ArrayList<>();
        int count=0;
        System.out.print("Nhap duong dan file can doc: ");
        FileInputStream myFile = new FileInputStream(input.nextLine());
        input = new Scanner(System.in);
        System.out.print("Nhap từ cần đếm: ");
        String w=input.nextLine();
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                content.add(scanner.nextLine());
            }
        }
        for (String string : content) {
            String[] temp=string.split(w);
//            for (String string1 : temp) {
//                System.out.println(string1);
//            }
            count+=temp.length-1;
        }
        System.out.println("Tong so tu trong file la: "+count);
    }
}
