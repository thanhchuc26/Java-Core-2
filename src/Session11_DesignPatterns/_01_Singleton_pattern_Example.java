/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

/**
 *
 * @author June
 */
class Singleton {

    private static final Singleton singleton = new Singleton();

    // Mot private Constructor de ngan can bat cu lop nao khac khoi tao.
    private Singleton() {
    }

    /* Phuong thuc static 'instance' */
    public static Singleton getInstance() {
        return singleton;
    }

    /* Cac phuong thuc protected khac */
    protected static void demoMethod() {
        System.out.println("demoMethod cho singleton");
    }
}

public class _01_Singleton_pattern_Example {

    public static void main(String[] args) {
        Singleton tmp = Singleton.getInstance();
        tmp.demoMethod();
    }
}

/*
Mục đích của Singleton là để kiểm soát việc tạo ra đối tượng, giới hạn số lượng đối tượng tạo ra là chỉ một.
Giống như các trường static, chỉ có một trường Singleton xuất hiện cho mỗi lớp. 
Các Singleton thường kiểm soát sự truy cập tới nguồn như kết nối database hoặc socket.

Ví dụ, nếu bạn được phép có một kết nối tới database hoặc JDBC driver mà có vấn đề về đa luồng (multithreading), thì Singleton bảo đảm rằng chỉ có duy nhất một kết nối được tạo ra hoặc chỉ có một thread có thể truy cập kết nối đó tại một thời điểm.

Triển khai Singleton trong Java:
Sự triển khai đơn giản nhất gồm một private constructor và một trường để giữ kết quả, và một phương thức static accessor với tên như getInstance().
Trường private có thể được gán từ trong một khối khởi chạy tĩnh (static initializer), hoặc đơn giản hơn, bạn sử dụng một initializer. Phương thức getInstance() (mà phải là public) sau đó trả về instance này.
 */
