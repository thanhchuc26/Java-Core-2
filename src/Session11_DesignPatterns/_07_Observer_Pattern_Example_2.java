/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author June
 */
class ConcreteMessage1 extends Observable {

    String message;

    public void sendMessage(String str) {
        this.message = str;
        this.setChanged();
        notifyObservers();
    }
}

class ConcreteObserver1 implements Observer {

    private ConcreteMessage1 message;

    public ConcreteObserver1() {
    }

    public ConcreteObserver1(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        ConcreteMessage1 message = (ConcreteMessage1) o;
        System.out.println("Message receive: " + message.message);
    }

}

public class _07_Observer_Pattern_Example_2 {

    public static void main(String[] args) {
        ConcreteMessage1 message = new ConcreteMessage1();
        Observer receive1 = new ConcreteObserver1(message);
        Observer receive2 = new ConcreteObserver1(message);
        System.out.println("Begin send message HELLO 10 times:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Send " + (i + 1) + ": ");
            message.sendMessage("HELLO");
        }
    }
}
/*
Mẫu thiết kế Observer đã được tích hợp vào package java.util trong Java API. Để áp dụng mẫu thiết kế này:
-ConcreteMessage cần thừa kế từ lớp Observable. Trong phương thức sendMessage(), sau khi thay đổi dữ liệu, gọi các phương thức setChanged() và notifyObservers() của giao diện Observable để tự động cập nhật cho các đối tượng Observer có đăng ký nhận cảnh báo thay đổi với nó.
-ConcreteObserver, phần hiển thị của ứng dụng (giao diện người dùng GUI, report, sơ đồ, bảng biểu) thường cài đặt giao diện Observer. Trong constructor, nó tự đăng ký để nhận cảnh báo thay đổi diễn ra trên đối tượng Observable mà nó quan tâm. Đồng thời cài đặt phương thức update(Observable, Object), trong đó nó nhận dữ liệu thay đổi từ đối tượng Observable để cập nhật phần hiển thị của mình.

Ví dụ sau đây sẽ sử dụng mẫu thiết kế Observer được tích hợp trong Java API
 */
