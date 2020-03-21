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
public class internationalization_currency_example {

    private static void printCurrency(double number, Locale locale) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        String currency = formatter.format(number);
        System.out.println("Currency "+number + " in " + locale+": "+currency);
    }

    public static void main(String[] args) throws InterruptedException {
        int lang;
        double number = 123456.789;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Display currency 123456.789 by:");
            System.out.println("1. Currency by Germany language");
            System.out.println("2. Currency by United states language");
            System.out.println("3. Currency by France language");
            System.out.println("4. Currency by Japan language");
            System.out.println("5. Currency by default language");
            System.out.println("6. Exit program");
            System.out.print("Please choose your language: ");
            lang = s.nextInt();
            switch (lang) {
                case 1:
                    System.out.println("======================================");
                    printCurrency(number, Locale.GERMANY);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("======================================");
                    printCurrency(number, Locale.US);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("======================================");
                    printCurrency(number, Locale.FRANCE);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("======================================");
                    printCurrency(number, Locale.JAPAN);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 5:
                    Locale.setDefault(new Locale("vi", "VN"));
                    System.out.println("======================================");
                    printCurrency(number, Locale.getDefault());
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
            }
        } while (lang != 6);
    }
}
