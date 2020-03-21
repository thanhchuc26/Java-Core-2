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

public class create_database_SqlServer_JDBC {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://192.168.61.139;";
    static final String DATABASENAME = "softech1;";
    static final String USER = "user=sa;";
    static final String PASS = "password=123";

    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL + USER + PASS);
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE " + DATABASENAME;
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(create_database_SqlServer_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
