/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session10_AdvancedJDBCFeatures;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author June
 */
public class CachedRowSet_Example {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost;";
    static final String DATABASENAME = "databasename=softech1";
    static final String USER = "sa";
    static final String PASS = "123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        try (CachedRowSet rowSet = new CachedRowSetImpl()) {
            rowSet.setUrl(DB_URL + DATABASENAME);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASS);
            String sql = "select studentid, batch, name from student";
            rowSet.setCommand(sql);
            rowSet.execute();
            while (rowSet.next()) {
                System.out.print("\nStudent ID: " + rowSet.getString("studentid"));
                System.out.print("\nBatch: " + rowSet.getString("batch"));
                System.out.println("\nName: " + rowSet.getString("name"));
                System.out.print("\n=================");
            }
            rowSet.beforeFirst();
        }
    }
}

/*
CachedRowSet (disconnected RowSet) không yêu cầu phải duy trì một kết nối với cơ sở dữ liệu. 
Nó chỉ thực hiện kết nối khi có submit và điều này sẽ làm tăng hiệu suất cho cơ sở dữ liệu. 
CachedRowSet có thể thực hiện các hoạt động sau đây trên cơ sở dữ liệu

Insert: Để thực hiện thêm một dòng dữ liệu vào bảng, chúng ta sử dụng phương thức moveToInsertRow()

Update: Phương thức updateRow() được sử dụng để cập nhật một dòng dữ liệu của bảng

Delete: Sử dụng phương thức deleteRow() để xoá một dòng dữ liệu của bảng.

Select: Một đối tượng CachedRowSet là có thể cuộn (scrollable) và điều này cho phép chúng ta 
duyệt bản ghi theo nhiều cách. Một khi con trỏ nằm tại dòng mong muốn, các phương thức getter 
có thể được gọi để lấy các giá trị của các cột.

CachedRowSet cho phép chúng ta duyệt dữ liệu với các thao tác:
First (bản ghi đầu tiên), 
Next (bản ghi kế tiếp), 
Previous (bản ghi trước) 
và Last (bản ghi cuối cùng). 
Bên dưới là các phương thức tương ứng.

Hiển thị bản ghi đầu tiên

crs.beforeFirst();
if(crs.next()) {
   crs.getDatatype(String columnLabel);
}
Hiển thị bản ghi kế tiếp (Sử dụng phương thức crs.isLast() 
để kiểm tra xem đang là bản ghi  cuối cùng chưa. Nếu trả về true thì đang ở bản ghi cuối cùng)

if(crs.next()) {
   crs.getDatatype(String columnLabel);
}
Hiển thị bản ghi trước (Sử dụng phương thức crs.isFirst() 
để kiểm tra xem đang là bản ghi đầu tiên chưa. Nếu trả về true thì đang ở đầu bản ghi đầu tiên)

if(crs.previous()) {
   crs.getDatatype(String columnLabel);
}
Hiển thị bản ghi cuối cùng

crs.afterLast();
if(crs.previous()) {
   crs.getDatatype(String columnLabel);
}
 */
