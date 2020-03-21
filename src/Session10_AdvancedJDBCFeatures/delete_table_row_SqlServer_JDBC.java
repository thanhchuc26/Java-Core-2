/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_AdvancedJDBCFeatures;

/**
 *
 * @author June
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class delete_table_row_SqlServer_JDBC {

    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName(session10Constants.JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
            System.out.println("Deleting table row...");
            stmt = conn.createStatement();
            String sql = "delete student where batch='batch131'";
            stmt.executeUpdate(sql);
            System.out.println("Row(s) in table deleted successfully...");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(delete_table_row_SqlServer_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
