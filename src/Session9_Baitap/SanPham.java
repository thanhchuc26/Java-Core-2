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
public class SanPham {

    String maSP;
    String tenSP;
    String maLoaiSP;
    float giaBan;
    int soLuong;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String maLoaiSP, float giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maLoaiSP = maLoaiSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public static SanPham getSPByMaSP(String maSP) throws ClassNotFoundException, SQLException {
        String sql = "select MaSP, TenSP, MaLoaiSP, GiaBan, SoLuong from SANPHAM where MaSP=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maSP);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            SanPham sanPham = new SanPham(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("MaLoaiSP"), rs.getFloat("GiaBan"), rs.getInt("SoLuong"));
            prepareStatement.close();
            connection.close();
            return sanPham;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static void insertNewSanPham(SanPham sanPham) throws ClassNotFoundException, SQLException {
        String sql = "insert into SANPHAM values(?,?,?,?,?)";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, sanPham.getMaSP());
            preparedStatement.setString(2, sanPham.getTenSP());
            preparedStatement.setString(3, sanPham.getMaLoaiSP());
            preparedStatement.setFloat(4, sanPham.getGiaBan());
            preparedStatement.setInt(5, sanPham.getSoLuong());
            preparedStatement.executeUpdate();
        }
    }

    public static SanPham getSPByMaLoaiSP(String maLoaiSP) throws ClassNotFoundException, SQLException {
        String sql = "select MaSP, TenSP, MaLoaiSP, GiaBan, SoLuong from SANPHAM where MaLoaiSP=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maLoaiSP);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            SanPham sanPham = new SanPham(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("MaLoaiSP"), rs.getFloat("GiaBan"), rs.getInt("SoLuong"));
            prepareStatement.close();
            connection.close();
            return sanPham;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static void deleteSPByMSP(String maSP) throws ClassNotFoundException, SQLException {
        String sql = "delete from SANPHAM where MaSP=?";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, maSP);
            prepareStatement.executeUpdate();
        }
    }

    public static ArrayList<SanPham> getAllSanPham() throws ClassNotFoundException, SQLException {
        String sql = "select MaSP, TenSP, MaLoaiSP, GiaBan, SoLuong from SANPHAM";
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("MaLoaiSP"), rs.getFloat("GiaBan"), rs.getInt("SoLuong"));
                listSanPham.add(sanPham);
            }
        }
        return listSanPham;
    }

    @Override
    public String toString() {
        return "\t\tMa san pham: " + maSP + "\n"
                + "\t\tTen san pham: " + tenSP + "\n"
                + "\t\tMa loai san pham: " + maLoaiSP + "\n"
                + "\t\tGia ban: " + giaBan + "\n"
                + "\t\tSo luong: " + soLuong;
    }

}
