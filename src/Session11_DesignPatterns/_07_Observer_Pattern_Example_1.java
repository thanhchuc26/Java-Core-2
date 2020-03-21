/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author June
 */
interface myObserver {

    public void update();
}

interface myMessage {

    public void addObserver(myObserver observer);

    public void deleteObserver(myObserver observer);

    public void notifyObserver();
}

class ConcreteMessage implements myMessage {

    String message;
    List<myObserver> listObservers = new ArrayList<>();

    @Override
    public void addObserver(myObserver observer) {
        listObservers.add(observer);
    }

    @Override
    public void deleteObserver(myObserver observer) {
        listObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (myObserver observer : listObservers) {
            observer.update();
        }
    }

    public void sendMessage(String str) {
        this.message = str;
        notifyObserver();
    }
}

class ConcreteObserver implements myObserver {

    private ConcreteMessage message;

    public ConcreteObserver() {
    }

    public ConcreteObserver(ConcreteMessage message) {
        this.message = message;
        this.message.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Message receive: " + this.message.message);
    }

}

public class _07_Observer_Pattern_Example_1 {

    public static void main(String[] args) {
        ConcreteMessage message = new ConcreteMessage();
        myObserver receive1 = new ConcreteObserver(message);
        myObserver receive2 = new ConcreteObserver(message);
        System.out.println("Begin send message HELLO 10 times:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Send " + (i + 1) + ": ");
            message.sendMessage("HELLO");
        }
    }
}
/*
Mẫu thiết kế Observer định nghĩa một phụ thuộc một-nhiều, trong đó, nếu đối tượng một (Subject, còn gọi là Observable) thay đổi trạng thái, tất cả các đối tượng nhiều (Observer) phụ thuộc đối tượng một sẽ được thông báo và tự động cập nhật.
Phía một thường là dữ liệu, phía nhiều thường là giao diện người dùng.
Mẫu thiết kế này còn gọi là Dependents, Publish/Subcribe hoặc Source/Listener

Ví dụ:
- myObserver: Khai báo giao diện với phương thức chính update(). Phương thức này có thể truy cập đối tượng myMessage mà nó đăng ký, cập nhật Observer với trạng thái thay đổi của myMessage.

- myMessage: giao diện cho đối tượng dữ liệu, khai báo các phương thức chính:
    + addObserver(): thêm các Observer vào danh sách đăng ký các đối tượng cần phải thông báo về sự thay đổi.
    + deleteObserver(): xóa Observer chỉ định ra khỏi danh sách đăng ký các đối tượng cần phải thông báo về sự thay đổi.
    + notifyObserver(): thông báo cho các Observer đã đăng ký về những thay đổi trên myMessage.

- ConcreteMessage: cài đặt giao diện myMessage. Vì thường là đối tượng dữ liệu, nó lưu giữ trạng thái mà các đối tượng Observer quan tâm. Khi trạng thái này thay đổi, các Observer đăng ký với nó sẽ được thông báo.

- ConcreteObserver: cài đặt giao diện của myObserver. Constructor của nó thường yêu cầu phải đăng ký nó cho đối tượng myMessage mà nó theo dõi. Khi được thông báo, nó sẽ thực thi một tác vụ gì đó, ví dụ thay đổi giao diện, cập nhật biểu đồ.
 */
