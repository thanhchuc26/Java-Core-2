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
public class LoaiSP {

    String maLoaiSP;
    String tenLoaiSP;

    public LoaiSP() {
    }

    public LoaiSP(String maLoaiSP, String tenLoaiSP) {
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public static LoaiSP getLoaiSPByMaLoaiSP(String maLoaiSP) throws ClassNotFoundException, SQLException {
        String sql = "select MaLoaiSP, TenLoaiSP from LoaiSP where MaLoaiSP=?";
        Connection connection = connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, maLoaiSP);
        ResultSet rs = prepareStatement.executeQuery();
        if (rs.next()) {
            LoaiSP loaiSP = new LoaiSP(rs.getString("MaLoaiSP"), rs.getString("TenLoaiSP"));
            prepareStatement.close();
            connection.close();
            return loaiSP;
        } else {
            prepareStatement.close();
            connection.close();
            return null;
        }
    }

    public static void insertNewLoaiSP(LoaiSP loaiSP) throws ClassNotFoundException, SQLException {
        String sql = "insert into LOAISP values(?,?)";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, loaiSP.getMaLoaiSP());
            preparedStatement.setString(2, loaiSP.getTenLoaiSP());
            preparedStatement.executeUpdate();
        }
    }

    public static void deleteLoaiSPByMaLoaiSP(String maLoaiSP) throws ClassNotFoundException, SQLException {
        String sql = "delete from LOAISP where MaLoaiSP=?";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, maLoaiSP);
            prepareStatement.executeUpdate();
        }
    }

    public static ArrayList<LoaiSP> getAllLoaiSP() throws ClassNotFoundException, SQLException {
        String sql = "select MaLoaiSP, TenLoaiSP from LOAISP";
        ArrayList<LoaiSP> listLoaiSP = new ArrayList<>();
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP(rs.getString("MaLoaiSP"), rs.getString("TenLoaiSP"));
                listLoaiSP.add(loaiSP);
            }
        }
        return listLoaiSP;
    }

    @Override
    public String toString() {
        return "\t\tMa loai san pham: "+maLoaiSP+"\n"
                +"\t\tTen san pham: "+tenLoaiSP;
    }
    
}
