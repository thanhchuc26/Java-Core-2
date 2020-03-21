/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session12_InternationalizationAndLocalization;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class internationalization_number_example {

    private static void printNumber(double number, Locale locale) {
        NumberFormat formatter = NumberFormat.getNumberInstance(locale);
        String strNumber = formatter.format(number);
        System.out.println("Number 123456.789 in " + locale + ": " + strNumber);
    }

    public static void main(String[] args) throws InterruptedException {
        int lang;
        double number=123456.789;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Display number 123456.789 by:");
            System.out.println("1. Number by Germany language");
            System.out.println("2. Number by United states language");
            System.out.println("3. Number by France language");
            System.out.println("4. Number by Japan language");
            System.out.println("5. Number by default language");
            System.out.println("6. Exit program");
            System.out.print("Please choose your language: ");
            lang = s.nextInt();
            switch (lang) {
                case 1:
                    System.out.println("======================================");
                    printNumber(number, Locale.GERMANY);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("======================================");
                    printNumber(number, Locale.US);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("======================================");
                    printNumber(number, Locale.FRANCE);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("======================================");
                    printNumber(number, Locale.JAPAN);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 5:
                    Locale.setDefault(new Locale("vi", "VN"));
                    System.out.println("======================================");
                    printNumber(number, Locale.getDefault());
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
            }
        } while (lang != 6);
    }
}
