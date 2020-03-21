/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.Console;
import java.io.IOError;

/**
 *
 * @author June
 */
public class console_class {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Console not available");
        }
        try {
            String userName = console.readLine("Enter your username: ");
            char[] password = console.readPassword("Enter your password: ");
//            System.out.println("Your username: " + userName);
//            System.out.println("Your password: " + new String(password));
            console.printf("------------------------\n");
            console.printf("Information you have input:\n");
            console.printf("Your username: %s\n", userName);
            console.printf("Your password: %s", new String(password));
        } catch (IOError error) {
            console.printf("I/O error: %s\n", error.getMessage());
        }
    }
}
