/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_Baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author June
 */
class SinhVien3 {

    private String ten;
    private String lop;
    private float diem;

    public SinhVien3() {
    }

    public SinhVien3(String ten, String lop, float diem) {
        this.ten = ten;
        this.lop = lop;
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public void hienThiThongTin(int i) {
        System.out.println("Thong tin sinh vien thu " + i + ": ");
        System.out.println("\tTen: " + this.ten);
        System.out.println("\tLop: " + this.lop);
        System.out.println("\tDiem: " + this.diem);
    }
}

public class session05_baitap07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        ArrayList<String> content = new ArrayList<>();
        ArrayList<SinhVien3> arrListSinhVien = new ArrayList<>();
        System.out.print("Nhap duong dan file can doc: ");
        FileInputStream myFile = new FileInputStream(input.nextLine());
        try (Scanner scanner = new Scanner(myFile)) {
            while (scanner.hasNextLine()) {
                content.add(scanner.nextLine());
            }
        }
        for (String string : content) {
            String[] temp = string.split("@");
            arrListSinhVien.add(new SinhVien3(temp[0], temp[1], Float.parseFloat(temp[2])));
        }
        int i = 0;
        for (SinhVien3 sinhVien : arrListSinhVien) {
            i++;
            sinhVien.hienThiThongTin(i);
        }
    }
}
