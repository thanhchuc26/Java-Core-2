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
 * @author nguyenducthao
 */
public class BanHang {

    String maNV;
    String maSP;
    int soLuongDaBan;

    public BanHang() {
    }

    public BanHang(String maNV, String maSP, int soLuongDaBan) {
        this.maNV = maNV;
        this.maSP = maSP;
        this.soLuongDaBan = soLuongDaBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public static BanHang getBanHangByMaNVAndMaSP(String maNV, String maSP) throws ClassNotFoundException, SQLException {
        String sql = "select MaNV, MaSP, SoLuongDaBan from BANHANG where MaNV=? and MaSP=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maNV);
        prepareStatement.setString(2, maSP);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            BanHang banHang = new BanHang(rs.getString("MaNV"), rs.getString("MaSP"), rs.getInt("SoLuongDaBan"));
            prepareStatement.close();
            connection.close();
            return banHang;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static void insertNewBanHang(BanHang banHang) throws ClassNotFoundException, SQLException {
        String sql = "insert into BANHANG values(?,?,?)";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, banHang.getMaNV());
            preparedStatement.setString(2, banHang.getMaSP());
            preparedStatement.setInt(3, banHang.getSoLuongDaBan());
            preparedStatement.executeUpdate();
        }
    }

    public static BanHang getBanHangByMaSP(String maSP) throws ClassNotFoundException, SQLException {
        String sql = "select MaNV, MaSP, SoLuongDaBan from BANHANG where MaSP=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maSP);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            BanHang banHang = new BanHang(rs.getString("MaNV"), rs.getString("MaSP"), rs.getInt("SoLuongDaBan"));
            prepareStatement.close();
            connection.close();
            return banHang;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static BanHang getBanHangByMaNV(String maNV) throws ClassNotFoundException, SQLException {
        String sql = "select MaNV, MaSP, SoLuongDaBan from BANHANG where MaNV=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maNV);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            BanHang banHang = new BanHang(rs.getString("MaNV"), rs.getString("MaSP"), rs.getInt("SoLuongDaBan"));
            prepareStatement.close();
            connection.close();
            return banHang;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static void deleteBanHangByMaNVAndMaSP(String maNV, String maSP) throws ClassNotFoundException, SQLException {
        String sql = "delete from BANHANG where MaNV=? and MaSP=?";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, maNV);
            prepareStatement.setString(2, maSP);
            prepareStatement.executeUpdate();
        }
    }

    public static ArrayList<BanHang> getAllBanHang() throws ClassNotFoundException, SQLException {
        String sql = "select MaNV, MaSP, SoLuongDaBan from BANHANG";
        ArrayList<BanHang> listBanHang = new ArrayList<>();
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                BanHang banHang = new BanHang(rs.getString("MaNV"), rs.getString("MaSP"), rs.getInt("SoLuongDaBan"));
                listBanHang.add(banHang);
            }
        }
        return listBanHang;
    }

    @Override
    public String toString() {
        return "\t\tMa nhan vien: " + maNV + "\n"
                + "\t\tMa san pham: " + maSP + "\n"
                + "\t\tSo luong da ban: " + soLuongDaBan;
    }

}
