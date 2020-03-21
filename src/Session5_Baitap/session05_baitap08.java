/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_Baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author June
 */
class SinhVien {

    private String hoTen;
    private int namSinh;
    private float diemTrungBinh;

    public SinhVien() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên của sinh viên: ");
        this.hoTen = input.nextLine();
        System.out.print("Nhập năm sinh của sinh viên: ");
        this.namSinh = input.nextInt();
        System.out.print("Nhập điểm trung bình của sinh viên: ");
        this.diemTrungBinh = input.nextFloat();
    }

    public SinhVien(String hoTen, int namSinh, float diemTrungBinh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String gethoTen() {
        return hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void sethoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public void hienThiThongTin() {
        System.out.println("Họ và tên của sinh viên: " + this.hoTen);
        System.out.println("Năm sinh của sinh viên: " + this.namSinh);
        System.out.println("Điểm trung bình của sinh viên: " + this.diemTrungBinh);
    }
}

public class session05_baitap08 {

    static void ghiVaoFile(File file, SinhVien sinhvien) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            try (FileWriter fw = new FileWriter(file, false)) { //true: ghi thêm vào cuối file. flase: ghi đè lên nội dung cũ
                fw.write("Họ và tên của sinh viên: " + sinhvien.gethoTen() + "\n");
                Integer I = sinhvien.getNamSinh();
                fw.write("Năm sinh của sinh viên: " + I.toString() + "\n");
                Float F = sinhvien.getDiemTrungBinh();
                fw.write("Điểm trung bình của sinh viên: " + F.toString() + "\n");
                fw.flush();
                fw.close();
            }
        }
    }

    static void docFile(File file) throws FileNotFoundException, IOException {
        FileReader fileRead = new FileReader(file);
        char[] noidung = new char[500];
        fileRead.read(noidung); // doc noi dung toi mang
        for (char c : noidung) {
            System.out.print(c); //in tung ky tu mot
        }
        fileRead.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("d:/session05/sinhvien.txt");
//        SinhVien sinhvien=new SinhVien();
        SinhVien sinhvien = new SinhVien("Nguyen Van Thanh", 1990, 10);
        System.out.println("------------------------");
        System.out.println("Thông tin của sinh viên:");
        sinhvien.hienThiThongTin();
        ghiVaoFile(file, sinhvien);
        System.out.println("------------------------------------------------------");
        System.out.println("Thông tin của sinh viên được đọc từ file sinhvien.txt:");
        docFile(file);
    }
}
