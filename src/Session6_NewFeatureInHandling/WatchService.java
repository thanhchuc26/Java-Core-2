/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

/**
 *
 * @author June
 */
public class WatchService {

    public static void main(String[] args) throws IOException, InterruptedException {
        // => Lấy về đối tượng Path có đường dẫn F:
        Path folderMonitored = Paths.get("D:/session06");

        // => Tạo đối tượng FileSystem
        FileSystem fileSystem = FileSystems.getDefault();

        // => Tạo đối tượng WatchService
        java.nio.file.WatchService watchService = fileSystem.newWatchService();

        // => Đăng ký theo dõi sự kiện cho folderMonitored bao gồm: CREATE, DELETE, MODIFY
        folderMonitored.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        boolean isValid = true;

        WatchKey watchKey;

        while (isValid) {
            watchKey = watchService.take();

            // => Xử lý logic cho từng sự kiện
            for (WatchEvent watchEvent : watchKey.pollEvents() /* gọi pollEvents() để lấy về List các event*/) {
                switch (watchEvent.kind().toString()) {
                    case "ENTRY_CREATE":
                        System.out.println(String.format("File %s duoc tao tren %s", watchEvent.context(), folderMonitored));
                        break;
                    case "ENTRY_DELETE":
                        System.out.println(String.format("File '%s' duoc xoa tren %s", watchEvent.context(), folderMonitored));
                        break;
                    case "ENTRY_MODIFY":
                        System.out.println(String.format("File '%s' duoc sua tren %s", watchEvent.context(), folderMonitored));
                        break;
                    default:
                }
            }
            isValid = watchKey.reset();
        }
    }
}

/*
- WatchService - là 1 interface, nó ánh xạ trực tiếp tới cơ chế thông báo sự kiện tệp tin
- Path - là 1 Immutable Class biểu diễn cho đường dẫn tới bất kỳ tệp tin nào
- Paths - là 1 Class, lớp này bao gồm các phương thức static có nhiệm vụ trả về 1 đối tượng Path
bằng cách convert 1 chuỗi đường dẫn hoặc URI.
- FileSystem - đây là lớp đại diện cho hệ thống tệp tin, được sử dụng để có được đường dẫn đến các tệp tin.
- FileSystems - đây là lớp chứa Factory Method trả về đối tượng FileSystem. 
Lớp này định nghĩa phương thức getDefault() để trả về hệ thống tệp tin mặc định 
và các phương thức để xây dựng các hệ thống tệp tin khác nhau.
- StandardWatchEventKinds - đây là lớp định nghĩa các loại event chuẩn bao gồm:
+ ENTRY_CREATE (detect có file được tạo)
+ ENTRY_DELETE (detect có file bị xóa)
+ ENTRY_MODIFY (detect có file được sửa)
+ OVERFLOW
- WatchKey - đây là 1 interface đại diện cho kết quả đăng ký của đối tượng Path,
kết quả đăng ký thành công WatchKey sẽ ở trạng thái ready và được coi là hợp lệ.
Một đối tượng WatchKey duy trì tính hợp lệ cho tới khi xuất hiện 1 trong những vấn đề sau:
+ Phương thức WatchKey.cancel() được gọi.
+ Thư mục theo dõi không còn nữa.
+ Đối tượng WatchService được đóng.
 */
