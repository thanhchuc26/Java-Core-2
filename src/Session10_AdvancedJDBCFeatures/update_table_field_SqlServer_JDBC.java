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

public class update_table_field_SqlServer_JDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Updating table...");
        stmt = conn.createStatement();
        String sql = "update student set "
                + "batch='newBatch',name='newName' where studentid='softech001'";
        stmt.executeUpdate(sql);
        System.out.println("Data of table updated successfully...");
        stmt.close();
        conn.close();
    }
}
