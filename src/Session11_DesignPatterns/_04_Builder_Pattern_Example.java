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
class Computer2 {
    // required parameters

    private String ram;
    private String hdd;

// optional parameters
    private boolean isGraphicsEnabled;
    private boolean isBluetoothEnabled;

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public boolean isIsGraphicsEnabled() {
        return isGraphicsEnabled;
    }

    public boolean isIsBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer2(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.isGraphicsEnabled = builder.isGraphicsEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" + "ram=" + ram + ", hdd=" + hdd + ", isGraphicsEnabled=" + isGraphicsEnabled + ", isBluetoothEnabled=" + isBluetoothEnabled + '}';
    }

    public static class ComputerBuilder {

        // required parameters
        private String ram;
        private String hdd;

        // optional parameters
        private boolean isGraphicsEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String ram, String hdd) {
            this.ram = ram;
            this.hdd = hdd;
        }

        public ComputerBuilder setIsGraphicsEnabled(boolean isGraphicsEnabled) {
            this.isGraphicsEnabled = isGraphicsEnabled;
            return this;
        }

        public ComputerBuilder setIsBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer2 build() {
            return new Computer2(this);
        }
    }
}

public class _04_Builder_Pattern_Example {

    public static void main(String[] args) {
        Computer2 computer = new Computer2.ComputerBuilder("ram", "hdd").setIsGraphicsEnabled(true).setIsBluetoothEnabled(true).build();
        System.out.println(computer);
        System.out.println("Class of object computer: " + computer.getClass());
    }
}

/*
Builder Pattern được xây dựng để khắc phục một số nhược điểm của Factory Pattern và Abstract Factory Pattern.

Builder pattern được sử dụng để xử lý các vấn đề còn tồn tại với Factory Pattern và Abstract Factory Pattern khi mà Object có nhiều thuộc tính.

Có ba vấn đề chính với  Factory Pattern và Abstract Factory Pattern khi Object có nhiều thuộc tính:

Quá nhiều tham số phải truyền vào từ phía client tới Factory Class
Một số tham số có thể là tùy chọn nhưng trong Factory Pattern, chúng ta phải gửi tất cả tham số, với tham số tùy chọn nếu ko nhập gì thì sẽ truyền là null.
Nếu một Object có quá nhiều thuộc tính thì việc tạo sẽ phức tạp.
Chúng ta có thể xử lý những vấn đề này với một số lượng lớn các tham số bằng việc cung cấp một hàm khởi tạo với những tham số bắt buộc và các method getter/setter để cài đặt các tham số tùy chọn. Vấn đề với hướng tiếp cận này là trạng thái của Object sẽ không nhất quán cho tới khi tất cả các thuộc tính được cài đặt một cách rõ ràng

Builder pattern xử lý các vấn đề này bằng việc cung cấp một cách xây dựng đối tượng từng bước một và cung cấp một method để trả về đối tượng cuối cùng.

Ví dụ:
- Tạo một static nested class (đây được gọi là builder class) và copy tất cả các tham số từ class bên ngoài vào. Chúng ta nên đặt tên của static nested class này theo định dạng tên class + Builder. Ví dụ class là Computer thì builder class sẽ là ComputerBuilder.
- Class Builder có một hàm khởi tạo public với tất cả các thuộc tính bắt buộc.
- Class Builder có các method setter cho các tham số tùy chọn.
- Cung cấp method build() trong Class Builder để trả về đối tượng mà client cần.
 */
