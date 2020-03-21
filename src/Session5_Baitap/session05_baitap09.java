/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_Baitap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author June
 */
class SinhVien1 implements Serializable {

    private String hoTen;
    private int namSinh;
    private float diemTrungBinh;

    public SinhVien1() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên của sinh viên: ");
        this.hoTen = input.nextLine();
        System.out.print("Nhập năm sinh của sinh viên: ");
        this.namSinh = input.nextInt();
        System.out.print("Nhập điểm trung bình của sinh viên: ");
        this.diemTrungBinh = input.nextFloat();
    }

    public SinhVien1(String hoTen, int namSinh, float diemTrungBinh) {
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

public class session05_baitap09 {

    static void ghiVaoFile(File file, SinhVien1 sinhvien) throws IOException{
        if (!file.exists()) {
            file.createNewFile();
        } else {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sinhvien);
            oos.close();
        }
    }
static void docFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException  {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        SinhVien1 sinhvien=(SinhVien1) ois.readObject();
        sinhvien.hienThiThongTin();
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        File file = new File("d:/session05/sinhvien.dat");
//        SinhVien sinhvien=new SinhVien();
        SinhVien1 sinhvien = new SinhVien1("Nguyen Van Thanh", 1990, 10);
        System.out.println("------------------------");
        System.out.println("Thông tin của sinh viên:");
        sinhvien.hienThiThongTin();
        ghiVaoFile(file, sinhvien);
        System.out.println("------------------------------------------------------");
        System.out.println("Thông tin của sinh viên được đọc từ file sinhvien.dat:");
        docFile(file);
    }
}
