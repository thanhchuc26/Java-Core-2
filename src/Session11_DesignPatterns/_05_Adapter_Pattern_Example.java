/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

/**
 *
 * @author June
 */
class CheckNumberAdaptee {

    public boolean checkNumber(String input) {
        String regex = "[0-9]+";
        return input.matches(regex);
    }
}

interface PhoneTarget {

    boolean checkPhoneNumber(String input);
}

class Adapter implements PhoneTarget {

    CheckNumberAdaptee checkNumberAdaptee = new CheckNumberAdaptee();

    @Override
    public boolean checkPhoneNumber(String input) {
        if (!checkNumberAdaptee.checkNumber(input)) {
            return false;
        }
        if ((input.length() < 10) || (input.length() > 11)) {
            return false;
        }
        return true;
    }
}

public class _05_Adapter_Pattern_Example {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        String phone1 = "12345678910";
        String phone2 = "12345";
        System.out.println(phone1 + " is phone number: " + adapter.checkPhoneNumber(phone1));
        System.out.println(phone2 + " is phone number: " + adapter.checkPhoneNumber(phone2));
        System.out.println("");
        PhoneTarget phoneTarget = new Adapter();
        System.out.println(phone1 + " is phone number: " + phoneTarget.checkPhoneNumber(phone1));
        System.out.println(phone2 + " is phone number: " + phoneTarget.checkPhoneNumber(phone2));
    }
}

/*
Adapter Pattern là một mẫu cấu trúc (Structural Pattern).

Adapter Pattern cho phép các inteface không liên quan tới nhau có thể làm việc cùng nhau.

Đối tượng giúp kết nối các interface gọi là Adapter.

Ví dụ trong cuộc sống:
Cái sạc điện thoại  hoạt động giống như adapter kết nối giữa nguồn điện của điện thoại là 3V với nguồn điện lưới là 240V.
Cái phích cắm điện có 3 chân nhưng ổ điện chỉ có 2 lỗ thì phải dùng thêm 1 cái bộ chuyển để chuyển từ 3 chân sang 2 chân – bộ chuyển này cũng được gọi là adapter…

Client giao tiếp với inteface Target nhưng cần dùng tới chức năng ở Adaptee.

Target sẽ khai báo chức năng của Adaptee và dùng implement của nó là Adapter để cài đặt lại chức năng đó.

Adapter sẽ giao tiếp với Adaptee để dùng lại 1 phần hoặc toàn bộ chức năng của Adaptee để phục vụ client.

Ví dụ
Mình có 1 class CheckNumberAdaptee chuyên thực hiện việc kiểm tra 1 chuỗi ký tự có phải là kiểu số không.

Client bây giờ cần chức năng kiểm tra 1 chuỗi ký tự có phải là số điện không.

Rõ ràng client không thể dùng trực tiếp được CheckNumberAdaptee, ta sẽ dùng thêm class Adapter để thực hiện chức năng kiểm tra số điện thoại bằng cách sử dụng chức năng của CheckNumberAdaptee kiểm tra chuỗi ký tự đó có phải là kiểu số không, nếu đúng thì kiểm tra thêm điều kiện của số điện thoại.
 */
