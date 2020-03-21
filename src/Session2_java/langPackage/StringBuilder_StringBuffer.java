/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

/**
 *
 * @author June
 */
public class StringBuilder_StringBuffer {

    public static void main(String[] args) {
        String str1 = new String("Softech");
        StringBuilder str2 = new StringBuilder("Softech");
        str1.concat(".vn");
        System.out.println("str1 sau khi noi chuoi .vn: "+str1);
        str2.append(".vn");
        System.out.println("str2 sau khi noi chuoi .vn: "+str2);
    }

}

//StringBuilder và StringBuffer là rất giống nhau, điều khác biệt là tất cả các phương thức của StringBuffer 
//đã được đồng bộ, nó thích hợp khi bạn làm việc với ứng dụng đa luồng, 
//nhiều luồng có thể truy cập vào một đối tượng StringBuffer cùng lúc. 
//Trong khi đó StringBuilder có các phương thức tương tự nhưng không được đồng bộ, 
//nhưng vì vậy mà hiệu suất của nó cao hơn, bạn nên sử dụng StringBuilder trong ứng dụng đơn luồng, 
//hoặc sử dụng như một biến địa phương trong một phương thức.
