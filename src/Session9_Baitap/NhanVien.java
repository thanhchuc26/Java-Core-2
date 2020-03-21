/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session9_Baitap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author June
 */
public class NhanVien {

    String maNV;
    String hoTenNV;
    boolean gioiTinh;
    String queQuan;
    int tuoi;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTenNV, boolean gioiTinh, String queQuan, int tuoi) {
        this.maNV = maNV;
        this.hoTenNV = hoTenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.tuoi = tuoi;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public static NhanVien getNhanVienByMaNV(String maNV) throws ClassNotFoundException, SQLException {
        String sql = "select MaNV, HoTenNV, GioiTinh, QueQuan, Tuoi from NHANVIEN where MaNV=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maNV);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            NhanVien nhanVien = new NhanVien(rs.getString("MaNV"), rs.getString("HoTenNV"), rs.getBoolean("GioiTinh"), rs.getString("QueQuan"), rs.getInt("Tuoi"));
            prepareStatement.close();
            connection.close();
            return nhanVien;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static void insertNewNhanVien(NhanVien nhanVien) throws ClassNotFoundException, SQLException {
        String sql = "insert into NHANVIEN values(?,?,?,?,?)";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nhanVien.getMaNV());
            preparedStatement.setString(2, nhanVien.getHoTenNV());
            preparedStatement.setBoolean(3, nhanVien.isGioiTinh());
            preparedStatement.setString(4, nhanVien.getQueQuan());
            preparedStatement.setInt(5, nhanVien.getTuoi());
            preparedStatement.executeUpdate();
        }
    }

    public static void deleteNhanVienByMaNV(String maNV) throws ClassNotFoundException, SQLException {
        String sql = "delete from NHANVIEN where MaNV=?";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, maNV);
            prepareStatement.executeUpdate();
        }
    }

    public static ArrayList<NhanVien> getAllNhanVien() throws ClassNotFoundException, SQLException {
        String sql = "select MaNV, HoTenNV, GioiTinh, QueQuan, Tuoi from NHANVIEN";
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString("MaNV"), rs.getString("HoTenNV"), rs.getBoolean("GioiTinh"), rs.getString("QueQuan"), rs.getInt("Tuoi"));
                listNhanVien.add(nhanVien);
            }
        }
        return listNhanVien;
    }

    @Override
    public String toString() {
        if (isGioiTinh()) {
            return "\t\tMa nhan vien: " + maNV + "\n"
                    + "\t\tHo ten nhan vien: " + hoTenNV + "\n"
                    + "\t\tGioi tinh: Nam\n"
                    + "\t\tQue quan: " + queQuan + "\n"
                    + "\t\tTuoi: " + tuoi;
        } else {
            return "\t\tMa nhan vien: " + maNV + "\n"
                    + "\t\tHo ten nhan vien: " + hoTenNV + "\n"
                    + "\t\tGioi tinh: Nu\n"
                    + "\t\tQue quan: " + queQuan + "\n"
                    + "\t\tTuoi: " + tuoi;
        }
    }
}
