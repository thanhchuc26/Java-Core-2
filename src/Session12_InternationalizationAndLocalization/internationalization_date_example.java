/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session12_InternationalizationAndLocalization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class internationalization_date_example {

    private static void printDate(Date currentDate, Locale locale) {
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String strDate = formatter.format(currentDate);
        System.out.println("Current date "+currentDate+" in "+locale + " with LONG format: " + strDate);
    }

    public static void main(String[] args) throws InterruptedException {
        int lang;
        Date currentDate = new Date();
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Display current date "+currentDate+" by:");
            System.out.println("1. Date by Germany language");
            System.out.println("2. Date by United states language");
            System.out.println("3. Date by France language");
            System.out.println("4. Date by Japan language");
            System.out.println("5. Date by default language");
            System.out.println("6. Exit program");
            System.out.print("Please choose your language: ");
            lang = s.nextInt();
            switch (lang) {
                case 1:
                    System.out.println("======================================");
                    printDate(currentDate, Locale.GERMANY);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("======================================");
                    printDate(currentDate, Locale.US);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("======================================");
                    printDate(currentDate, Locale.FRANCE);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("======================================");
                    printDate(currentDate, Locale.JAPAN);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 5:
                    Locale.setDefault(new Locale("vi", "VN"));
                    System.out.println("======================================");
                    printDate(currentDate, Locale.getDefault());
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
            }
        } while (lang != 6);
    }
}
