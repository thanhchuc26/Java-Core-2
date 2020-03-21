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
abstract class Computer {

    public abstract String getCPU();

    public abstract String getRAM();

    public abstract String getHDD();

    @Override
    public String toString() {
        return "CPU: " + this.getCPU() + ", RAM: " + this.getRAM() + ", HDD: " + this.getHDD();
    }

}

class PC extends Computer {

    private String cpu;
    private String ram;
    private String hdd;

    public PC() {
    }

    public PC(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }
}

class Server extends Computer {

    private String cpu;
    private String ram;
    private String hdd;

    public Server() {
    }

    public Server(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }
}

class ComputerFactory {

    public static Computer getComputer(String type, String cpu, String ram, String hdd) {
        if (type.equalsIgnoreCase("pc")) {
            return new PC(cpu, ram, hdd);
        } else {
            if (type.equalsIgnoreCase("server")) {
                return new Server(cpu, ram, hdd);
            } else {
                return null;
            }
        }
    }
}

public class _02_Factory_Pattern_Example {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "cpu pc", "ram pc", "hdd pc");
        Computer server = ComputerFactory.getComputer("server", "cpu server", "ram server", "hdd server");
        System.out.println("Class of pc object: " + pc.getClass());
        System.out.println("Class of server object: " + server.getClass());
        System.out.println("PC information: " + pc);
        System.out.println("Server information: " + server);
    }
}

/*
Factory Pattern được sử dụng khi có một class cha (super class) với nhiều class con (sub-class), dựa trên đầu vào và phải trả về 1 trong những class con đó.

Lợi ích của Factory Pattern
- Cung cấp 1 hướng tiếp cận với Interface thay thì các cài đặt.
- Mở rộng code dễ dàng hơn (Khi muốn mở rộng thêm 1 loại class con khác, ta chỉ việc thêm mới nó và sửa đầu vào trong Factory Method là được).

Ta có class cha là Computer và 2 class con Server và PC.
ComputerFactory thực hiện trả về đối tượng Server hoặc PC tùy theo dữ liệu đầu vào.
 */
