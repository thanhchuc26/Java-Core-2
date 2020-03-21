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
abstract class Computer1 {

    public abstract String getCPU();

    public abstract String getRAM();

    public abstract String getHDD();

    @Override
    public String toString() {
        return "CPU: " + this.getCPU() + ", RAM: " + this.getRAM() + ", HDD: " + this.getHDD();
    }
}

class PC1 extends Computer1 {

    private String cpu;
    private String ram;
    private String hdd;

    public PC1() {
    }

    public PC1(String cpu, String ram, String hdd) {
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

class Server1 extends Computer1 {

    private String cpu;
    private String ram;
    private String hdd;

    public Server1() {
    }

    public Server1(String cpu, String ram, String hdd) {
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

interface ComputerAbstractFactory1 {

    public Computer1 createComputer1();
}

class PCFactory1 implements ComputerAbstractFactory1 {

    private String cpu;
    private String ram;
    private String hdd;

    public PCFactory1() {
    }

    public PCFactory1(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Computer1 createComputer1() {
        return new PC1(cpu, ram, hdd);
    }

}

class ServerFactory1 implements ComputerAbstractFactory1 {

    private String cpu;
    private String ram;
    private String hdd;

    public ServerFactory1() {
    }

    public ServerFactory1(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Computer1 createComputer1() {
        return new Server1(cpu, ram, hdd);
    }

}

class ComputerFactory1 {

    public static Computer1 getComputer1(ComputerAbstractFactory1 computerAbstractFactory) {
        return computerAbstractFactory.createComputer1();

    }
}

public class _03_Abstract_Factory_Pattern_Example {

    public static void main(String[] args) {
        Computer1 pc = ComputerFactory1.getComputer1(new PCFactory1("cpu pc", "ram pc", "hdd pc"));
        Computer1 server = ComputerFactory1.getComputer1(new ServerFactory1("cpu server", "ram server", "hdd server"));
        System.out.println(pc);
        System.out.println(server);
        System.out.println("Class of pc object: " + pc.getClass());
        System.out.println("Class of server object: " + server.getClass());
    }
}

/*
Abstract Factory pattern rất giống với Factory Pattern ngoại trừ việc nó là factory của các factory.

Nếu bạn đã quen với  Factory Pattern thì bạn sẽ thấy nó chỉ có 1 Factory class, factory class này sẽ trả về các class con (sub-class) dựa trên dầu vào (factory class sử dụng if-else hoặc switch để xác định class con đầu ra).

Trong Abstract Factory pattern, chúng ta không cần if-else hoặc switch. Mỗi sub-class sẽ có một factory class. Abstract Factory class sẽ trả về sub-class dựa trên đầu vào là factory class.

Lợi ích của Abstract Factory Pattern.
- Abstract Factory pattern cung cấp hưỡng tiếp cận code bằng interface thay vì các cài đặt (Giống với Factory Pattern)
- Abstract Factory pattern là “factory của các factory” và có thể dễ dạng mở rộng để chứa thêm các factory và các sub-class
- Abstract Factory giúp tránh được việc sử dụng điều kiện logic như bên trong Factory Pattern.

Ta có class cha là computer và 2 class con Server và PC.

ComputerAbstractFactory là một interface cung cấp phương thức trả về đối tượng Computer.

ServerFactory và PCFactory sẽ cài đặt các phương thức của ComputerAbstractFactory.

ComputerFactory sẽ sử dụng ComputerAbstractFactory để tạo đối tượng Computer. (Trường hợp ComputerAbstractFactory là ServerFactory thì sẽ trả về đối tượng Server, trường hợp ComputerAbstractFactory là PCFactory thì sẽ trả về đối tượng PC)
*/