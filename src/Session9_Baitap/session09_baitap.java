/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session9_Baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class session09_baitap {

    private static String readFile(String fileName) throws FileNotFoundException, IOException {
        File file = new File("");
        file = new File(file.getAbsolutePath() + "/src/session09_baitap/" + fileName);
        String sql = "";
        try (FileReader fileReader = new FileReader(file)) {
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                sql += String.valueOf((char) ch);
            }
        }
        return sql;
    }

    private static void PressAnyKeyToContinue(String str) {
        Scanner input = new Scanner(System.in);
        System.out.println(str);
        input.nextLine();
    }

    private static void case1() throws FileNotFoundException, IOException, ClassNotFoundException {
        String sql = readFile("createDB.txt");
        System.out.println("Dang tao database '" + sql.substring(sql.lastIndexOf(" ")).trim() + "'...");
        try (Connection connection = connectDB.connectSQLServerToCreateDB(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            PressAnyKeyToContinue("Tao database 'SellManager' thanh cong. Bam phim bat ky de tiep tuc.");
        } catch (SQLException ex) {
            PressAnyKeyToContinue("Database 'SellManager' da ton tai. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case2() throws IOException, ClassNotFoundException {
        String sql = readFile("create_table_LOAISP.txt");
        System.out.println("Dang tao table 'LOAISP'...");
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            PressAnyKeyToContinue("Tao table 'LOAISP' thanh cong. Bam phim bat ky de tiep tuc.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            PressAnyKeyToContinue("Table 'LOAISP' da ton tai. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case3() throws FileNotFoundException, IOException, ClassNotFoundException {
        String sql = readFile("create_table_SANPHAM.txt");
        System.out.println("Dang tao table 'SANPHAM'...");
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            PressAnyKeyToContinue("Tao table 'SANPHAM' thanh cong. Bam phim bat ky de tiep tuc.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            PressAnyKeyToContinue("Table 'SANPHAM' da ton tai. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case4() throws IOException, ClassNotFoundException {
        String sql = readFile("create_table_NHANVIEN.txt");
        System.out.println("Dang tao table 'NHANVIEN'...");
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            PressAnyKeyToContinue("Tao table 'NHANVIEN' thanh cong. Bam phim bat ky de tiep tuc.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            PressAnyKeyToContinue("Table 'NHANVIEN' da ton tai. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case5() throws IOException, ClassNotFoundException {
        String sql = readFile("create_table_BANHANG.txt");
        System.out.println("Dang tao table 'BANHANG'...");
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            PressAnyKeyToContinue("Tao table 'BANHANG' thanh cong. Bam phim bat ky de tiep tuc.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            PressAnyKeyToContinue("Table 'BANHANG' da ton tai. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case6() throws ClassNotFoundException, SQLException {
        System.out.println("Nhap du lieu cho bang LOAISP:");
        Scanner input = new Scanner(System.in);
        System.out.print("Ma loai san pham: ");
        String maLoaiSP = input.nextLine();
        System.out.print("Ten loai san pham: ");
        String tenLoaiSP = input.nextLine();
        LoaiSP loaiSP = LoaiSP.getLoaiSPByMaLoaiSP(maLoaiSP);
        if (loaiSP != null) {
            PressAnyKeyToContinue("Ma loai san pham " + maLoaiSP + " da ton tai. Hay nhap ma loai san pham khac.");
        } else {
            loaiSP = new LoaiSP(maLoaiSP, tenLoaiSP);
            LoaiSP.insertNewLoaiSP(loaiSP);
            PressAnyKeyToContinue("Da nhap thanh cong mot loai san pham. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case7() throws ClassNotFoundException, SQLException {
        System.out.println("Nhap du lieu cho bang SANPHAM:");
        Scanner input = new Scanner(System.in);
        System.out.print("Ma san pham: ");
        String maSP = input.nextLine();
        SanPham sanPham = SanPham.getSPByMaSP(maSP);
        if (sanPham != null) {
            PressAnyKeyToContinue("Ma san pham " + maSP + " da ton tai. Hay nhap ma san pham khac.");
        }
        System.out.print("Ten san pham: ");
        input = new Scanner(System.in);
        String tenSP = input.nextLine();
        String maLoaiSP = "";
        do {
            System.out.print("Ma loai san pham: ");
            input = new Scanner(System.in);
            maLoaiSP = input.nextLine();
            LoaiSP loaiSP = LoaiSP.getLoaiSPByMaLoaiSP(maLoaiSP);
            if (loaiSP == null) {
                System.out.println("Ma loai san pham " + maLoaiSP + " khong ton tai. Hay nhap ma loai san pham khac.");
            } else {
                break;
            }
        } while (true);
        System.out.print("Gia ban: ");
        float giaBan = input.nextFloat();
        System.out.print("So luong: ");
        int soLuong = input.nextInt();
        sanPham = new SanPham(maSP, tenSP, maLoaiSP, giaBan, soLuong);
        SanPham.insertNewSanPham(sanPham);
        PressAnyKeyToContinue("Da nhap thanh cong mot san pham. Bam phim bat ky de tiep tuc.");
    }

    private static void case8() throws ClassNotFoundException, SQLException {
        System.out.println("Nhap du lieu cho bang NHANVIEN:");
        Scanner input = new Scanner(System.in);
        System.out.print("Ma nhan vien: ");
        String maNV = input.nextLine();
        NhanVien nhanVien = NhanVien.getNhanVienByMaNV(maNV);
        if (nhanVien != null) {
            PressAnyKeyToContinue("Ma nhan vien " + maNV + " da ton tai. Hay nhap ma nhan vien khac.");
        } else {
            System.out.print("Ho ten nhan vien: ");
            input = new Scanner(System.in);
            String hoTenNV = input.nextLine();
            boolean gioiTinh;
            int iGioiTinh;
            System.out.print("Gioi tinh (0: Nu - 1: Nam): ");
            input = new Scanner(System.in);
            iGioiTinh = input.nextInt();
            if (iGioiTinh == 0) {
                gioiTinh = true;
            } else {
                gioiTinh = false;
            }
            System.out.print("Que quan: ");
            input = new Scanner(System.in);
            String queQUan = input.nextLine();
            System.out.print("Tuoi: ");
            int tuoi = input.nextInt();
            nhanVien = new NhanVien(maNV, hoTenNV, gioiTinh, queQUan, tuoi);
            NhanVien.insertNewNhanVien(nhanVien);
            PressAnyKeyToContinue("Da nhap thanh cong mot nhan vien. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case9() throws ClassNotFoundException, SQLException {
        System.out.println("Nhap du lieu cho bang BANHANG:");
        Scanner input = new Scanner(System.in);
        System.out.print("Ma nhan vien: ");
        String maNV = input.nextLine();
        NhanVien nhanVien = NhanVien.getNhanVienByMaNV(maNV);
        if (nhanVien == null) {
            PressAnyKeyToContinue("Ma nhan vien " + maNV + " khong ton tai. Hay nhap ma nhan vien khac.");
        } else {
            System.out.print("Ma san pham: ");
            input = new Scanner(System.in);
            String maSP = input.nextLine();
            if (SanPham.getSPByMaSP(maSP) == null) {
                PressAnyKeyToContinue("Ma san pham " + maSP + " khong ton tai. Hay nhap ma san pham khac.");
            } else {
                if (BanHang.getBanHangByMaNVAndMaSP(maNV, maSP) != null) {
                    PressAnyKeyToContinue("Ma nhan vien " + maNV + ", ma san pham " + maSP + " nay da ton tai.  Hay nhap ma nhan vien va ma san pham khac.");
                } else {
                    System.out.print("So luong da ban: ");
                    int soLuongDaBan = input.nextInt();
                    BanHang.insertNewBanHang(new BanHang(maNV, maSP, soLuongDaBan));
                    PressAnyKeyToContinue("Da nhap thanh cong mot ban hang. Bam phim bat ky de tiep tuc.");
                }
            }
        }
    }

    private static void case10() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma loai san pham can xoa: ");
        String maLoaiSP = input.nextLine();
        if (LoaiSP.getLoaiSPByMaLoaiSP(maLoaiSP) == null) {
            PressAnyKeyToContinue("Ma loai san pham " + maLoaiSP + " khong ton tai. Hay nhap ma loai san pham khac.");
        } else {
            if (SanPham.getSPByMaLoaiSP(maLoaiSP) != null) {
                PressAnyKeyToContinue("Ma loai san pham " + maLoaiSP + " dang ton tai trong table SANPHAM. Khong the xoa duoc.");
            } else {
                LoaiSP.deleteLoaiSPByMaLoaiSP(maLoaiSP);
                PressAnyKeyToContinue("Da xoa thanh cong ma loai san pham " + maLoaiSP);
            }
        }
    }

    private static void case11() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma san pham can xoa: ");
        String maSP = input.nextLine();
        if (SanPham.getSPByMaSP(maSP) == null) {
            PressAnyKeyToContinue("Ma san pham " + maSP + " khong ton tai. Hay nhap ma san pham khac.");
        } else {
            if (BanHang.getBanHangByMaSP(maSP) != null) {
                PressAnyKeyToContinue("Ma san pham " + maSP + " dang ton tai trong table BANHANG. Khong the xoa duoc.");
            } else {
                SanPham.deleteSPByMSP(maSP);
                PressAnyKeyToContinue("Da xoa thanh cong ma san pham " + maSP);
            }
        }
    }

    private static void case12() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String maNV = input.nextLine();
        if (NhanVien.getNhanVienByMaNV(maNV) == null) {
            PressAnyKeyToContinue("Ma nhan vien " + maNV + " khong ton tai. Hay nhap ma nhan vien khac.");
        } else {
            if (BanHang.getBanHangByMaNV(maNV) != null) {
                PressAnyKeyToContinue("Ma nhan vien " + maNV + " dang ton tai trong table BANHANG. Khong the xoa duoc.");
            } else {
                NhanVien.deleteNhanVienByMaNV(maNV);
                PressAnyKeyToContinue("Da xoa thanh cong ma nhan vien " + maNV);
            }
        }
    }

    private static void case13() throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String maNV = input.nextLine();
        System.out.print("Nhap ma san pham can xoa: ");
        String maSP = input.nextLine();
        if (BanHang.getBanHangByMaNVAndMaSP(maNV, maSP) == null) {
            PressAnyKeyToContinue("Ma nhan vien " + maNV + " va ma san pham " + maSP + " khong ton tai. Hay nhap ma nhan vien va ma san pham khac.");
        } else {
            BanHang.deleteBanHangByMaNVAndMaSP(maNV, maSP);
            PressAnyKeyToContinue("Da xoa thanh cong ban hang co ma nhan vien " + maNV + ", ma san pham " + maSP);
        }
    }

    private static void case14() throws ClassNotFoundException, SQLException {
        ArrayList<LoaiSP> listLoaiSP = LoaiSP.getAllLoaiSP();
        if (listLoaiSP.isEmpty()) {
            System.out.println("Du lieu table LOAISP: Chua co du lieu");
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        } else {
            System.out.println("Du lieu table LOAISP: ");
            for (int i = 0; i < listLoaiSP.size(); i++) {
                System.out.println("\tLoai san pham " + (i + 1) + ": ");
                System.out.println(listLoaiSP.get(i));
            }
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case15() throws ClassNotFoundException, SQLException {
        ArrayList<SanPham> listSanPham = SanPham.getAllSanPham();
        if (listSanPham.isEmpty()) {
            System.out.println("Du lieu table SAMPHAM: Chua co du lieu");
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        } else {
            System.out.println("Du lieu table LOAISP: ");
            for (int i = 0; i < listSanPham.size(); i++) {
                System.out.println("\tSan pham " + (i + 1) + ": ");
                System.out.println(listSanPham.get(i));
            }
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case16() throws ClassNotFoundException, SQLException {
        ArrayList<NhanVien> listNhanVien = NhanVien.getAllNhanVien();
        if (listNhanVien.isEmpty()) {
            System.out.println("Du lieu table NHANVIEN: Chua co du lieu");
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        } else {
            System.out.println("Du lieu table NHANVIEN: ");
            for (int i = 0; i < listNhanVien.size(); i++) {
                System.out.println("\tNhan vien " + (i + 1) + ": ");
                System.out.println(listNhanVien.get(i));
            }
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case17() throws ClassNotFoundException, SQLException {
        ArrayList<BanHang> listBanHang = BanHang.getAllBanHang();
        if (listBanHang.isEmpty()) {
            System.out.println("Du lieu table BANHANG: Chua co du lieu");
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        } else {
            System.out.println("Du lieu table BANHANG: ");
            for (int i = 0; i < listBanHang.size(); i++) {
                System.out.println("\tBan hang " + (i + 1) + ": ");
                System.out.println(listBanHang.get(i));
            }
            PressAnyKeyToContinue("Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case18() throws ClassNotFoundException, SQLException {
        if (!SanPham.getAllSanPham().isEmpty()) {
            PressAnyKeyToContinue("Du lieu table LOAISP dang ton tai trong table SANPHAM. Khong the xoa duoc.");
        } else {
            String sql = "drop table LOAISP";
            try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
            PressAnyKeyToContinue("Da xoa thanh cong table LOAISP. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case19() throws ClassNotFoundException, SQLException {
        if (!BanHang.getAllBanHang().isEmpty()) {
            PressAnyKeyToContinue("Du lieu table SANPHAM dang ton tai trong table BANHANG. Khong the xoa duoc.");
        } else {
            String sql = "drop table SANPHAM";
            try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
            PressAnyKeyToContinue("Da xoa thanh cong table SANPHAM. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case20() throws ClassNotFoundException, SQLException {
        if (!BanHang.getAllBanHang().isEmpty()) {
            PressAnyKeyToContinue("Du lieu table NHANVIEN dang ton tai trong table BANHANG. Khong the xoa duoc.");
        } else {
            String sql = "drop table NHANVIEN";
            try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
            PressAnyKeyToContinue("Da xoa thanh cong table NHANVIEN. Bam phim bat ky de tiep tuc.");
        }
    }

    private static void case21() throws ClassNotFoundException, SQLException {
        String sql = "drop table BANHANG";
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
        PressAnyKeyToContinue("Da xoa thanh cong table BANHANG. Bam phim bat ky de tiep tuc.");
    }

    private static void case22() throws IOException, ClassNotFoundException, SQLException {
        ArrayList<LoaiSP> listLoaiSP = LoaiSP.getAllLoaiSP();
        if (listLoaiSP.isEmpty()) {
            PressAnyKeyToContinue("Table LOAISP chua co du lieu. Bam phim bat ky de tiep tuc.");
        } else {
            File file = new File("");
            file = new File(file.getAbsolutePath() + "/src/session09_baitap/LOAISP.txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (int i = 0; i < listLoaiSP.size(); i++) {
                    fileWriter.write("Dong " + (i + 1) + ": \n");
                    fileWriter.write("Ma loai san pham: " + listLoaiSP.get(i).getMaLoaiSP() + "\n");
                    fileWriter.write("Ten loai san pham: " + listLoaiSP.get(i).getTenLoaiSP() + "\n");
                    fileWriter.write("=================================================\n");
                }
            }
            PressAnyKeyToContinue("Da xuat xong du lieu table LOAISP.");
        }
    }

    private static void case23() throws IOException, ClassNotFoundException, SQLException {
        ArrayList<SanPham> listSanPham = SanPham.getAllSanPham();
        if (listSanPham.isEmpty()) {
            PressAnyKeyToContinue("Table SAMPHAM chua co du lieu. Bam phim bat ky de tiep tuc.");
        } else {
            File file = new File("");
            file = new File(file.getAbsolutePath() + "/src/session09_baitap/SANPHAM.txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (int i = 0; i < listSanPham.size(); i++) {
                    fileWriter.write("Dong " + (i + 1) + ": \n");
                    fileWriter.write("Ma san pham: " + listSanPham.get(i).getMaSP() + "\n");
                    fileWriter.write("Ten san pham: " + listSanPham.get(i).getTenSP() + "\n");
                    fileWriter.write("Ma loai san pham: " + listSanPham.get(i).getMaLoaiSP() + "\n");
                    fileWriter.write("Gia ban: " + listSanPham.get(i).getGiaBan() + "\n");
                    fileWriter.write("So luong: " + listSanPham.get(i).getSoLuong() + "\n");
                    fileWriter.write("=================================================\n");
                }
            }
            PressAnyKeyToContinue("Da xuat xong du lieu table LOAISP.");
        }
    }

    private static void case24() throws IOException, ClassNotFoundException, SQLException {
        ArrayList<NhanVien> listNhanVien = NhanVien.getAllNhanVien();
        if (listNhanVien.isEmpty()) {
            PressAnyKeyToContinue("Table NHANVIEN chua co du lieu. Bam phim bat ky de tiep tuc.");
        } else {
            File file = new File("");
            file = new File(file.getAbsolutePath() + "/src/session09_baitap/NHANVIEN.txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (int i = 0; i < listNhanVien.size(); i++) {
                    fileWriter.write("Dong " + (i + 1) + ": \n");
                    fileWriter.write("Ma nhan vien: " + listNhanVien.get(i).getMaNV() + "\n");
                    fileWriter.write("Ho ten nhan vien: " + listNhanVien.get(i).getHoTenNV() + "\n");
                    if (listNhanVien.get(i).isGioiTinh()) {
                        fileWriter.write("Gioi tinh: Nam\n");
                    } else {
                        fileWriter.write("Gioi tinh: Nu\n");
                    }
                    fileWriter.write("Que quan: " + listNhanVien.get(i).getQueQuan() + "\n");
                    fileWriter.write("Tuoi: " + listNhanVien.get(i).getTuoi() + "\n");
                    fileWriter.write("=================================================\n");
                }
            }
            PressAnyKeyToContinue("Da xuat xong du lieu table NHANVIEN.");
        }
    }

    private static void case25() throws IOException, ClassNotFoundException, SQLException {
        ArrayList<BanHang> listBanHang = BanHang.getAllBanHang();
        if (listBanHang.isEmpty()) {
            PressAnyKeyToContinue("Table BANHANG chua co du lieu. Bam phim bat ky de tiep tuc.");
        } else {
            File file = new File("");
            file = new File(file.getAbsolutePath() + "/src/session09_baitap/BANHANG.txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (int i = 0; i < listBanHang.size(); i++) {
                    fileWriter.write("Dong " + (i + 1) + ": \n");
                    fileWriter.write("Ma nhan vien: " + listBanHang.get(i).getMaNV() + "\n");
                    fileWriter.write("Ma san pham: " + listBanHang.get(i).getMaSP() + "\n");
                    fileWriter.write("So luong da ban: " + listBanHang.get(i).getSoLuongDaBan() + "\n");
                    fileWriter.write("=================================================\n");
                }
            }
            PressAnyKeyToContinue("Da xuat xong du lieu table BANHANG.");
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        byte luachon = 0;
        do {
            System.out.println("----------MENU----------");
            System.out.println("1. Tao database SellManager.");
            System.out.println("2. Tao table LOAISP");
            System.out.println("3. Tao table SANPHAM");
            System.out.println("4. Tao table NHANVIEN");
            System.out.println("5. Tao table BANHANG");
            System.out.println("6. Nhap du lieu cho table LOAISP.");
            System.out.println("7. Nhap du lieu cho table SANPHAM.");
            System.out.println("8. Nhap du lieu cho table NHANVIEN.");
            System.out.println("9. Nhap du lieu cho table BANHANG.");
            System.out.println("10. Xoa du lieu table LOAISP theo ma loai san pham. ");
            System.out.println("11. Xoa du lieu table SANPHAM theo ma san pham. ");
            System.out.println("12. Xoa du lieu table NHANVIEN theo ma nhan vien. ");
            System.out.println("13. Xoa du lieu table BANHANG theo ma nhan vien va ma san pham. ");
            System.out.println("14. Hien thi du lieu table LOAISP.");
            System.out.println("15. Hien thi du lieu table SANPHAM.");
            System.out.println("16. Hien thi du lieu table NHANVIEN.");
            System.out.println("17. Hien thi du lieu table BANHANG.");
            System.out.println("18. Xoa table LOAISP.");
            System.out.println("19. Xoa table SANPHAM.");
            System.out.println("20. Xoa table NHANVIEN.");
            System.out.println("21. Xoa table BANHANG.");
            System.out.println("22. Xuat du lieu trong table LOAISP va luu vao tap tin LoaiSP.txt");
            System.out.println("23. Xuat du lieu trong table SANPHAM va luu vao tap tin SANPHAM.txt");
            System.out.println("24. Xuat du lieu trong table NHANVIEN va luu vao tap tin NHANVIEN.txt");
            System.out.println("25. Xuat du lieu trong table BANHANG va luu vao tap tin BANHANG.txt");
            System.out.println("26. Thoat chuong trinh");
            System.out.print("Nhap lua cho cua ban: ");
            try {
                luachon = new Scanner(System.in).nextByte();
            } catch (InputMismatchException error) {
            }
            switch (luachon) {
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
                case 6:
                    case6();
                    break;
                case 7:
                    case7();
                    break;
                case 8:
                    case8();
                    break;
                case 9:
                    case9();
                    break;
                case 10:
                    case10();
                    break;
                case 11:
                    case11();
                    break;
                case 12:
                    case12();
                    break;
                case 13:
                    case13();
                    break;
                case 14:
                    case14();
                    break;
                case 15:
                    case15();
                    break;
                case 16:
                    case16();
                    break;
                case 17:
                    case17();
                    break;
                case 18:
                    case18();
                    break;
                case 19:
                    case19();
                    break;
                case 20:
                    case20();
                    break;
                case 21:
                    case21();
                    break;
                case 22:
                    case22();
                    break;
                case 23:
                    case23();
                    break;
                case 24:
                    case24();
                    break;
                case 25:
                    case25();
                    break;
                case 26:
                    System.exit(0);
                default:
                    PressAnyKeyToContinue("Chi duoc nhap tu 1 den 26. Bam phim bat ky de tiep tuc.");
            }
        } while (true);
    }
}
