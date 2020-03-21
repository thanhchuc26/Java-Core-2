/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session9_JDBC_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
public class ResultSetMetaData_Example {
    // Buoc 1: Ten cua driver va dia chi URL cua co so du lieu
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://ndt;";

    //  Ten database, nguoi dung va mat khau cua co so du lieu
    static final String DATABASENAME = "databaseName=softech;";
    static final String USER = "user=sa;";
    static final String PASS = "password=123";

    public static void main(String[] args) {
        Connection conn;
        Statement stmt;

        try {
            // Buoc 2: Dang ky Driver
            Class.forName(JDBC_DRIVER);
            // Buoc 3: Mo mot ket noi
            System.out.println("Dang ket noi toi co so du lieu ...");
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
            // Buoc 4: Thuc thi truy van
            System.out.println("Tao cac lenh truy van SQL ...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT studentid, batch, name FROM student";
            // Buoc 5: Lay du lieu tu Result Set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.println("Colum " + i + ": ");
                    System.out.println("\tColum name: " + rsmd.getColumnName(i));
                    System.out.println("\tColum type: " + rsmd.getColumnTypeName(i));
                    System.out.println("\tColum size: " + rsmd.getColumnDisplaySize(i));
                }
            }
            // Buoc 6: Don sach moi truong va giai phong resource
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResultSetMetaData_Example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
