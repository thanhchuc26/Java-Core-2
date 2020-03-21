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
public class internationalization_time_example {

    private static void printTime(String currentTime, Date currentDate, Locale locale) {
        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        String time = formatter.format(currentDate);
        System.out.println("Current time " + currentTime + " in locale: " + locale + " with long format: " + time);
    }

    public static void main(String[] args) throws InterruptedException {
        int lang;
        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.LONG, new Locale("vi", "VN"));
        Date currentDate = new Date();
        String currentTime = formatter.format(currentDate);
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Display current time " + currentTime + " by:");
            System.out.println("1. Time by Germany language");
            System.out.println("2. Time by United states language");
            System.out.println("3. Time by France language");
            System.out.println("4. Time by Japan language");
            System.out.println("5. Time by default language");
            System.out.println("6. Exit program");
            System.out.print("Please choose your language: ");
            lang = s.nextInt();
            switch (lang) {
                case 1:
                    System.out.println("======================================");
                    printTime(currentTime, currentDate, Locale.GERMANY);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("======================================");
                    printTime(currentTime, currentDate, Locale.US);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("======================================");
                    printTime(currentTime, currentDate, Locale.FRANCE);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("======================================");
                    printTime(currentTime, currentDate, Locale.JAPAN);
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 5:
                    Locale.setDefault(new Locale("vi", "VN"));
                    System.out.println("======================================");
                    printTime(currentTime, currentDate, Locale.getDefault());
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
            }
        } while (lang != 6);
    }
}
