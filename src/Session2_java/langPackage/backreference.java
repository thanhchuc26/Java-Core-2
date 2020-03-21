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
public class backreference {

    public static void main(String[] args) {
        String searchPattern = "(\\w\\w)\\1";
        Pattern pattern = Pattern.compile(searchPattern);
        String searchString;
        searchString = "Thisis a class";
//        searchString = "This a class";
        Matcher matcher = pattern.matcher(searchString);
//        System.out.println(matcher.find());
        if (matcher.find()) {
            System.out.println("Dulicate");
        } else {
            System.out.println("Not duplicate");
        }
    }
}
//Trong quá trình sử dụng group trong một biểu thức mẫu của Regular Expression, 
//chúng ta có thể sử dụng cơ chế backreference để so trùng với một mẫu trước đó 
//mà không cần phải viết lại toàn bộ mẫu.
//
//Trong một biểu thức Regular Expression, backreference được chỉ định thông qua kí tự \\x 
//ngay sau một group nào đó. Giá trị x chính là chỉ số của group.
//
//Một trong các ứng dụng của backreference là cho phép chúng ta có thể xác định 
//trong một chuỗi văn bản nào đó, có chứa các từ bị trùng lắp hay không.
