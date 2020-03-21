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

public class drop_table_SqlServer_JDBC {

    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName(session10Constants.JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
            System.out.println("Dropping table...");
            stmt = conn.createStatement();
            String sql = "drop table student";
            stmt.executeUpdate(sql);
            System.out.println("Table droped successfully...");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(drop_table_SqlServer_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
