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

public class insert_into_table_SqlServer_JDBC {

    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName(session10Constants.JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
            System.out.println("Inserting data into table...");
            stmt = conn.createStatement();
            String sql = "insert into student values "
                    + "('softech001','batch130','Nguyen Anh Tan'),"
                    + "('softech002','batch130','Nguyen Hong Hai'),"
                    + "('softech003','batch130','Phan Phuong Nam'),"
                    + "('softech004','batch131','Nguyen Huu Hiep'),"
                    + "('softech005','batch131','Vo Ngoc Hai'),"
                    + "('softech006','batch131','Tran Anh Tuan')";
            stmt.executeUpdate(sql);
            System.out.println("Insert data to table successfully...");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(insert_into_table_SqlServer_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
