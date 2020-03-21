/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_Baitap;

/**
 *
 * @author June
 */
class LoiChiaChoKhong extends Exception {

    LoiChiaChoKhong() {
        System.out.println("Lỗi chia cho 0");
    }

}

public class Baitap2 {

    void Chia2So(int num1, int num2) throws LoiChiaChoKhong {
        try {
            System.out.println("num1/num2=" + num1 / num2);
        } catch (ArithmeticException e) {
            throw new LoiChiaChoKhong();
        }
    }

    public static void main(String[] args) {
        int num1, num2;
        num1 = 10;
        num2 = 0;
        try {
            Baitap2 obj = new Baitap2();
            obj.Chia2So(10, 0);
        } catch (LoiChiaChoKhong e) {
        }
    }
}
