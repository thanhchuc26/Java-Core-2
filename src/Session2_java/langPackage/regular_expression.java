/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author June
 */
public class regular_expression {

    public static void main(String[] args) {
        // dùng biểu thức chính quy để kiểm tra chuỗi nhập vào có phải là 1 số nguyên hay ko
        Pattern pattern = Pattern.compile(".*[^0-9].*");    //tìm xem trong chuỗi có ký tự hay ko
//        Pattern pattern = Pattern.compile(".*\\D.*");
        Scanner input = new Scanner(System.in);
        System.out.print("Hay nhap vao 1 chuoi: ");
        String str = input.nextLine();
        if (pattern.matcher(str).matches()) {
            System.out.println("Chuoi " + str + " khong phai la 1 so");
        } else {
            System.out.println("Chuoi " + str + " la 1 so");
        }
        //kiểm tra địa chỉ email
        pattern = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        System.out.print("Hay nhap vao 1 dia chi email: ");
        input = new Scanner(System.in);
        str = input.nextLine();
        if (pattern.matcher(str).matches()) {
            System.out.println("Chuoi " + str + " la dia chi email");
        } else {
            System.out.println("Chuoi " + str + " khong phai la dia chi email");
        }
    }
}

//Regular expression: Biểu thức chính quy
//Một biểu thức chính quy là gì?
//Một biểu thức chính quy (regular expression) về bản chất là một mẫu để mô tả một tập hợp các chuỗi ký tự 
//chia sẻ chung mẫu này. Ví dụ, đây là một tập hợp các chuỗi ký tự có một số điều chung:
//* một chuỗi (a string).
//* một chuỗi dài hơn (a longer string).
//* một chuỗi rất dài (a much longer string).
//Mỗi chuỗi ký tự này đều bắt đầu bằng “a” và kết thúc bằng “string.” 
//API của các biểu thức chính quy của Java (Java Regular Expression) 
//giúp bạn thể hiện điều đó và làm nhiều việc lý thú với các kết quả.
//API của biểu thức chính quy (Regular Expression – hoặc viết tắt là regex) 
//của Java là khá giống với các công cụ biểu thức chính quy có sẵn trong ngôn ngữ Perl. 
//Nếu bạn là một lập trình viên của Perl, bạn sẽ cảm thấy đúng như đang ở nhà, 
//ít nhất là với cú pháp mẫu biểu thức chính quy của ngôn ngữ Java. 
//Tuy nhiên, nếu bạn không thường sử dụng biểu thức chính quy , chắc là nó có vẻ trông hơi lạ một chút. 
//Đừng lo lắng: không phải phức tạp như nó có vẻ thế đâu.
//
//API của biểu thức chính quy
//Năng lực về biểu thức chính quy của ngôn ngữ Java gồm có ba lớp cốt lõi mà bạn sẽ sử dụng hầu như mọi lúc:
//* Pattern, trong đó mô tả một mẫu chuỗi ký tự.
//* Matcher, để kiểm tra một chuỗi ký tự xem nó có khớp với mẫu không.
//* PatternSyntaxException, để báo cho bạn rằng một số thứ không thể chấp nhận được với mẫu mà bạn 
//đã thử định nghĩa.
//Cách tốt nhất để tìm hiểu về biểu thức chính quy là qua các ví dụ, 
//do đó trong phần này chúng ta sẽ tạo ra một ví dụ đơn giản trong CommunityApplication.main(). 
//Tuy nhiên, trước khi chúng ta tiến hành, điều quan trọng là hiểu được một số cú pháp mẫu biểu thức chính quy . 
//Chúng ta sẽ thảo luận điều đó chi tiết hơn trong phần kế tiếp.
//
//Cú pháp mẫu
//Một mẫu (pattern) biểu thức chính quy mô tả cấu trúc của chuỗi ký tự mà một biểu thức sẽ cố gắng tìm kiếm 
//trong một chuỗi ký tự đầu vào. Đây chính là tại sao biểu thức chính quy nhìn có vẻ hơi lạ thường. 
//Tuy nhiên, một khi bạn hiểu được cú pháp, để giải mã sẽ ít khó khăn hơn.
