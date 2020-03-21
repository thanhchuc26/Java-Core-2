/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author June
 */
public class matcher_groupCount {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("((X)(Y(Z)))");
        Matcher matcher = pattern.matcher("((X)(Y(Z)))");
        System.out.println("Group count is:" + matcher.groupCount());
    }
}
