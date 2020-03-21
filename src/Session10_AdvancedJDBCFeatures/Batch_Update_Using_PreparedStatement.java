/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_AdvancedJDBCFeatures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author June
 */
public class Batch_Update_Using_PreparedStatement {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn;
        PreparedStatement pstmt;
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Tao cac lenh truy van SQL ...");
        String sql = "insert into student values (?,?,?)";
        conn.setAutoCommit(false);
        pstmt = conn.prepareCall(sql);
        pstmt.setString(1, "softech007");
        pstmt.setString(2, "batch132");
        pstmt.setString(3, "Nguyen Cong Phu");
        pstmt.addBatch();
        pstmt.setString(1, "softech008");
        pstmt.setString(2, "batch132");
        pstmt.setString(3, "Le Tuan Anh");
        pstmt.addBatch();
        pstmt.executeBatch();
        conn.commit();
        conn.close();
        System.out.println("Tao cac lenh truy van SQL thanh cong");
    }
}
