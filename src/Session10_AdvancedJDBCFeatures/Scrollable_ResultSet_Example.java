/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_AdvancedJDBCFeatures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author June
 */
public class Scrollable_ResultSet_Example {

    static void TYPE_FORWARD_ONLY() throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Tao cac lenh truy van SQL ...");
        stmt = conn.createStatement();
        String sql = "SELECT studentid, batch, name FROM student";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getString("studentid"));
                System.out.println("Batch: " + rs.getString("batch"));
                System.out.println("Name: " + rs.getString("name"));
            }
//            rs.previous();//error
        }
        stmt.close();
        conn.close();
    }

    static void TYPE_SCROLL_INSENSITIVE() throws ClassNotFoundException, SQLException {
        Connection conn;
        Statement stmt;
        Class.forName(session10Constants.JDBC_DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        conn = DriverManager.getConnection(session10Constants.DB_URL + session10Constants.DATABASENAME + session10Constants.USER + session10Constants.PASS);
        System.out.println("Tao cac lenh truy van SQL ...");
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "SELECT studentid, batch, name FROM student";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getString("studentid"));
                System.out.println("Batch: " + rs.getString("batch"));
                System.out.println("Name: " + rs.getString("name"));
            }
            rs.previous();
            System.out.println("Student ID: " + rs.getString("studentid"));
            System.out.println("Batch: " + rs.getString("batch"));
            System.out.println("Name: " + rs.getString("name"));
        }
        stmt.close();
        conn.close();
    }

    static void TYPE_SCROLL_SENSITIVE() {
        System.out.println("Xem ví dụ update_ResultSet");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        TYPE_FORWARD_ONLY();
//        TYPE_SCROLL_INSENSITIVE();
        TYPE_SCROLL_SENSITIVE();
    }
}

/*
resultSetType:
TYPE_FORWARD_ONLY: ResultSet chỉ cho phép duyệt từ trên xuống dưới, từ trái sang phải. Đây là kiểu mặc định của các ResultSet.
TYPE_SCROLL_INSENSITIVE: ResultSet cho phép cuộn tiến lùi, sang trái, sang phải, nhưng không nhạy với các sự thay đổi dữ liệu dưới DB. 
Nghĩa là trong quá trình duyệt qua một bản ghi và lúc nào đó duyệt lại bản ghi đó, nó không lấy các dữ liệu mới nhất của bản ghi mà có thể bị ai đó thay đổi.
TYPE_SCROLL_SENSITIVE: ResultSet cho phép cuộn tiến lùi, sang trái, sang phải, và nhạy cảm với sự thay đổi dữ liệu.


resultSetConcurrency:
CONCUR_READ_ONLY: Khi duyệt dữ liệu với các ResultSet kiểu này bạn chỉ có thể đọc dữ liệu.
CONCUR_UPDATABLE: Khi duyệt dữ liệu với các ResultSet kiểu này bạn chỉ có thể thay đổi dữ liệu tại nơi con trỏ đứng, ví dụ update giá trị cột nào đó.

Sự kết hợp giữa resultSetType và resultSetConcurrency:
TYPE_FORWARD_ONLY + CONCUR_READ_ONLY
TYPE_SCROLL_INSENSITIVE + CONCUR_READ_ONLY
TYPE_SCROLL_SENSITIVE + CONCUR_UPDATABLE

Nếu sử dụng:
TYPE_SCROLL_INSENSITIVE + CONCUR_UPDATABLE -> Error 
 */
