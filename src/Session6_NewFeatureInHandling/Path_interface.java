/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author June
 */
public class Path_interface {

    public static void main(String[] args) {
        Path pathObj = Paths.get("d:/session06/session06.txt");
        System.out.printf("FileName is: %s%n", pathObj.getFileName());
        System.out.printf("Parent is: %s%n", pathObj.getParent());
        System.out.printf("Root directory is: %s%n", pathObj.getRoot());
        System.out.printf("Name count is: %d%n", pathObj.getNameCount());
        System.out.printf("Sub path 0-1: %s%n", pathObj.subpath(0, 1));
        System.out.printf("Sub path 0-2: %s%n", pathObj.subpath(0, 2));
        System.out.printf("Resovle path: %s%n", Paths.get("d:/session06").resolve("session06.txt"));
        System.out.printf("Resovle Sibling path: %s%n", Paths.get("d:/session06").resolveSibling("session06.txt"));
        System.out.printf("Resovle Sibling path: %s%n", Paths.get("d:/session06/session06_1.txt").resolveSibling("session06.txt"));
        System.out.printf("Is Absolute: %s%n", pathObj.isAbsolute());
        System.out.printf("startWith: %s%n", Paths.get("d:/session06/session06.txt").startsWith("d:/"));
        System.out.printf("endWith: %s%n", Paths.get("d:/session06/session06.txt").endsWith("session06.txt"));
    }
}
