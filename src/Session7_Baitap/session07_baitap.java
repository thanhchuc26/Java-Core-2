/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session7_Baitap;

/**
 *
 * @author June
 */
public class session07_baitap {

    public static void main(String[] args) {
        SMS sms = new SMS();
        Thread guiSMS = new Thread() {
            @Override
            public void run() {
                synchronized (sms) {
                    System.out.println("Bat dau gui SMS. Noi dung: test SMS");
                    sms.sendSMS("test SMS");
                    System.out.println("Da gui xong SMS");
                }
            }
        };

        Thread hienThiSMS = new Thread() {
            @Override
            public void run() {
                synchronized (sms) {
                    System.out.println("Da nhan duoc SMS. Noi dung: " + sms.getMessage());

                }
            }
        };

        guiSMS.start();
        hienThiSMS.start();
    }
}
