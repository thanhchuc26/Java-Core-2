/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_AdvancedJDBCFeatures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author June
 */
public class Batch_Update_Using_CallableStatement {

    static void create_Stored_Procedure_Insert_IN() throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Tao Stored Procedure ...");
        stmt = conn.createStatement();
        String sql = "create proc storeprocedure_insert_IN "
                + "@studentid nvarchar(10), @batch nvarchar(10), @name nvarchar(50) "
                + "AS "
                + "insert into student values "
                + "(@studentid, @batch, @name)";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
        System.out.println("Tao Stored Procedure thanh cong");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        create_Stored_Procedure_Insert_IN();
        Connection conn;
        CallableStatement cstmt;
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Tao cac lenh truy van SQL ...");
        String sql = "{call storeprocedure_insert_IN (?,?,?)}";
        conn.setAutoCommit(false);
        cstmt = conn.prepareCall(sql);
        cstmt.setString(1, "softech009");
        cstmt.setString(2, "batch133");
        cstmt.setString(3, "Le Van Hai");
        cstmt.addBatch();
        cstmt.setString(1, "softech010");
        cstmt.setString(2, "batch133");
        cstmt.setString(3, "Tran Nhat Kha");
        cstmt.addBatch();
        cstmt.executeBatch();
        conn.commit();
        conn.close();
        System.out.println("Tao cac lenh truy van SQL thanh cong");
    }
}
