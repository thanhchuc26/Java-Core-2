/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session6_NewFeatureInHandling;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author June
 */
public class PathMatcher {

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        java.nio.file.PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:" + "**.{java,class,txt}");
        Path path = Paths.get("D:/session06/session06.txt");
        System.out.println(pathMatcher.matches(path));
    }
}

/*
Glob là gì?
Hai phương thức trong một lớp Files chấp nhận một đối số glob, nhưng glob là gì?
Ta có thể sử dụng cú pháp glob để xác định dữ liệu có tương thích với mẫu hay không.
Một mẫu glob được quy định như một chuỗi và được ghép nối với các chuỗi khác, chẳng hạn
như thư mục hoặc tên tập tin. Cú pháp glob thường có một số quy tắc đơn giản sau:
Dấu * : tương ứng với một chuỗi bất kỳ (kể cả chuỗi rỗng).
Hai dấu ** : hoạt động giống như * nhưng vượt qua ranh giới thư mục. Cú pháp này
thường được áp dụng với đường dẫn đầy đủ.
Dấu ? : tương ứng với một ký tự chính xác.
Cặp ngoặc xoắn {} : chỉ định một tập hợp các mẫu con. Ví dụ:
{sun,moon,stars} tương đương với "sun", "moon", hoặc "stars".
{temp*, tmp*} tương ứng với tất cả các chuỗi bắt đầu với "temp" hoặc "tmp".
Cặp ngoặc vuông [] : tương ứng với một tập hợp các ký tự đơn lẻ, khi dấu gạch ngang
(-) được sử dụng thì đương đương với một dãy ký tự. Ví dụ:
[aeiou] tương ứng với bất kỳ ký tự nguyên âm thường nào.
[0-9] tương ứng với một ký số bất kỳ.
[A-Z] tương ứng với khớp với bất kỳ ký tự in hoa nào.
[a-z,A-Z] tương ứng với bất kỳ ký tự in thường hoặc in hoa nào.
Trong cặp ngoặc vuông ta cũng có quyền sử dụng những ký tự như *, ?, và \ để thiết
lập mẫu.
\ : biến ký tự đặc biệt ngay sau nó thành ký tự thông thường.
Tất cả các ký tự còn lại đều tương đương với chính nó (a là a, b là b, ...).
Nếu muốn chuyển các ký tự đặc biệt thành ký tự thông thường, ta sử dụng các ký tự sổ
ngược đặt trước ký tự đặc biệt đó, ví dụ: \\ tương ứng với một dấu gạch chéo thông
thường, \? tương ứng với dấu hỏi, \* tương ứng với dấu hoa thị thông thường.
Dưới đây là một số ví dụ về cách dùng glob:
*.html - tương ứng với một chuỗi bất kỳ kết thúc bằng .html
??? - tương ứng với một chuỗi bất kỳ có đúng ba chữ cái hay chữ số (abc, 123,...)
*[0-9]* - Tương ứng với một chuỗi bất kỳ có chứa ít nhất một giá trị số
*.{htm,html,pdf} - Tương ứng với một chuỗi bất kỳ kết thúc với .htm, .html hoặc .pdf
a?*.java - Tương ứng với một chuỗi bắt đầu bằng a, tiếp theo là ít nhất một chữ cái
hay chữ số, và kết thúc là .java
{foo*,*[0-9]*} - Tương ứng với một chuỗi bất kỳ bắt đầu bằng foo hoặc một chuỗi
bất kỳ chứa ít nhất một giá trị số.
Lưu ý: Nếu ta đang gõ những mẫu glob từ bàn phím và nó có chứa một trong các
ký tự đặc biệt thì ta phải đặt nó vào cặp nháy kép (chẳng hạn như "*"), sử dụng
dấu xổ ngược (\*), hoặc sử dụng bất cứ cơ chế escape được hỗ trợ tại dòng lệnh.
Cú pháp glob rất mạnh mẽ và dễ sử dụng. Tuy nhiên, nếu nó không đáp ứng đầy đủ cho
nhu cầu của bạn, bạn cũng có thể sử dụng một biểu thức chính quy (regular expression). Để
biết thêm thông tin, xin xem thêm bài viết về Regular Expressions.
Để biết thêm thông tin về các cú pháp glob, xin xem các đặc điểm kỹ thuật API của phương
thức getPathMatcher trong lớp FileSystem.
*/