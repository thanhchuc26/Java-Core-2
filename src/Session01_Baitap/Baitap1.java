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
public class Baitap1 {
    public static void main(String[] args) {
        int num1, num2;
        num1 = 10;
        num2 = 0;
        try {
            System.out.println("num1/num2=" + num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi chia cho 0");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
