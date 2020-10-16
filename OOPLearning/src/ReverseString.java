
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author June
 */
public class ReverseString {
    public static void main(String[] args) {
        String original, reverse = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter string to reverse: ");
        original = s.nextLine();
        for(int i = original.length()-1;i>=0;i--){
            reverse = reverse + original.charAt(i);
        }
        System.out.println("Reverse of the String: " + reverse);
    }
}
