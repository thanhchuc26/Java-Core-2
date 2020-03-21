/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.util.StringTokenizer;

/**
 *
 * @author June
 */
public class stringTokenizer {

    public static void main(String[] args) {
        String str = "Toi la hoc vien Sotech.vn";
        StringTokenizer st1 = new StringTokenizer(str, " ");
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }
    }
}
