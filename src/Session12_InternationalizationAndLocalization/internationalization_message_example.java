/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session12_InternationalizationAndLocalization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class internationalization_message_example {

    public static void main(String[] args) throws InterruptedException {
        int lang;
        Scanner s = new Scanner(System.in);
        ResourceBundle bundle;
        do {
            System.out.println("1. Message by Germany language");
            System.out.println("2. Message by United states language");
            System.out.println("3. Message by France language");
            System.out.println("4. Message by Japan language");
            System.out.println("5. Message by default language");
            System.out.println("6. Exit program");
            System.out.print("Please choose your language: ");
            lang = s.nextInt();
            switch (lang) {
                case 1:
                    bundle = ResourceBundle.getBundle("session12.MessagesBundle_de_DE", Locale.GERMANY);
                    System.out.println("======================================");
                    System.out.println("Greeting in " + Locale.GERMANY
                            + ": " + bundle.getString("greetings"));
                    System.out.println("Farewell in " + Locale.GERMANY
                            + ": " + bundle.getString("farewell"));
                    System.out.println("Inquiry in " + Locale.GERMANY
                            + ": " + bundle.getString("inquiry"));
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 2:
                    bundle = ResourceBundle.getBundle("session12.MessagesBundle_en_US", Locale.US);
                    System.out.println("======================================");
                    System.out.println("Greeting in " + Locale.US
                            + ": " + bundle.getString("greetings"));
                    System.out.println("Farewell in " + Locale.US
                            + ": " + bundle.getString("farewell"));
                    System.out.println("Inquiry in " + Locale.US
                            + ": " + bundle.getString("inquiry"));
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 3:
                    bundle = ResourceBundle.getBundle("session12.MessagesBundle_fr_FR", Locale.FRANCE);
                    System.out.println("======================================");
                    System.out.println("Greeting in " + Locale.FRANCE
                            + ": " + bundle.getString("greetings"));
                    System.out.println("Farewell in " + Locale.FRANCE
                            + ": " + bundle.getString("farewell"));
                    System.out.println("Inquiry in " + Locale.FRANCE
                            + ": " + bundle.getString("inquiry"));
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 4:
                    bundle = ResourceBundle.getBundle("session12.MessagesBundle_ja_JP", Locale.JAPAN);
                    System.out.println("======================================");
                    System.out.println("Greeting in " + Locale.JAPAN
                            + ": " + bundle.getString("greetings"));
                    System.out.println("Farewell in " + Locale.JAPAN
                            + ": " + bundle.getString("farewell"));
                    System.out.println("Inquiry in " + Locale.JAPAN
                            + ": " + bundle.getString("inquiry"));
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
                case 5:
                    Locale.setDefault(new Locale("vi", "VN"));
                    bundle = ResourceBundle.getBundle("session12.MessagesBundle");
                    System.out.println("======================================");
                    System.out.println("Greeting in " + Locale.getDefault()
                            + ": " + bundle.getString("greetings"));
                    System.out.println("Farewell in " + Locale.getDefault()
                            + ": " + bundle.getString("farewell"));
                    System.out.println("Inquiry in " + Locale.getDefault()
                            + ": " + bundle.getString("inquiry"));
                    System.out.println("======================================");
                    Thread.sleep(1000);
                    break;
            }
        } while (lang != 6);
    }
}

/*
Country     Language Code	Country Code
English         en                  EN
Germany         de                  DE
China           zh                  CN
Czech Republic	cs                  CZ
Netherlands	nl                  AN
France          fr                  FR
Italy           it                  IT
Japan           ja                  JP
Korea           ko                  KR
Russia          ru                  RU
Spain           es                  ES
Bulgaria	bg                  BG
Canada          ca                  CA
Croatia         hr                  HR
Denmark         da                  DK
Finland         fi                  FI
Greece          el                  GR
Hungary         hu                  HU
Indonesia	in                  ID
Latvia          lv                  LV
Lithuania	lt                  LT
Norway          nb                  NO
Portugal	pt                  PT
Romania         ro                  RO
Serbia          sr                  RS
Slovakia	sk                  SK
Slovenia	sl                  SI
Sweden          sv                  SE
Thailand	th                  TH
Turkey          tr                  TR
Ukraine         uk                  UA
Vietnam         vi                  VN
*/