/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_AdvancedJDBCFeatures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class PreparedStatement_Example {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        System.out.print("Nhập tên lớp cần truy vấn: ");
        Scanner input = new Scanner(System.in);
        String lop = input.nextLine();
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Tao cac lenh truy van SQL ...");
        String sql = "SELECT studentid, batch, name from student where batch like ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, lop);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String studentid = rs.getString("studentid");
                String batch = rs.getString("batch");
                String name = rs.getString("name");

                // Hien thi cac gia tri
                System.out.print("\nStudent ID: " + studentid);
                System.out.print("\nBatch: " + batch);
                System.out.println("\nName: " + name);
                System.out.print("\n=================");
            }
        }
        conn.close();
    }
}
