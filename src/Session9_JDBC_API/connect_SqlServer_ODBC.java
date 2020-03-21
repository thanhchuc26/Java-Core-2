/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session9_JDBC_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
public class connect_SqlServer_ODBC {

    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try (Connection con = DriverManager.getConnection("jdbc:odbc:MyDNS", "sa", "123")) {
                System.out.println("Connected to database");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(connect_SqlServer_ODBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*
Java 8 không sử dụng JDBC_ODBC được do nó đã bị remove từ Java 8
*/
