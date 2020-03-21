/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author June
 */
public class _14_ArraysClassExample {

    public static void main(String[] args) {
        /*
        1. Phương thức asList()
Chức năng: Phương thức asList() cho phép chuyển mảng thành danh sách (list) có cùng kiểu dữ liệu.

Cú pháp: List<Kiểu_dữ_liệu> tên_list = Arrays.asList(<Tên_mảng>)
         */
        String[] arrStr = new String[10];
        List<String> listStr = Arrays.asList(arrStr);

        /*
        2. Phương thức sort()
Chức năng: Phương thức sort() giúp sắp xếp các phần tử của mảng mặc định theo thứ tự tăng dần 
        dựa trên thuật toán quick sort.

Cú pháp: Arrays.sort(<Tên_mảng>)

hoặc: Arrays.sort(<Tên_mảng>, start_index, stop_index)

hoặc: Arrays.sort(<Tên_mảng>, Comparator)

hoặc: Arrays.sort(<Tên_mảng>, start_index, stop_index, Comparator)
        Chú ý: Khi sử dụng phương thức sort cần chú ý một số điểm sau

Đối với các kiểu dữ liệu nguyên thủy kiểu số như int, long, float, … hoặc với String 
        các bạn có thể sử dụng trực tiếp phương thức sort() mà không cần implement gì thêm.
Đối với các kiểu dữ liệu tự định nghĩa để sử dụng được phương thức sort(), 
        các bạn cần thực thi (implements) thêm giao diện (interface) Comparable, 
        cụ thể hơn là ghi đè (override) phương thức compareTo() của interface Comparable
Khi sắp xếp các phần tử trong một mảng con của mảng thì khi gọi 
        sort(arr, fromIndex, toIndex) thì sẽ chỉ có các phần tử từ fromIndex đến toIndex-1 được sắp xếp 
        (chứ phần tử ở toIndex không được sắp xếp).
Phương thức sort() còn cho bạn tùy biến cách so sánh các phần tử trong mảng 
        để đưa ra kết quả sắp xếp tương ứng bằng cách sử dụng Comparator mà mình sẽ đề cập đến trong bài viết khác.
         */
        int[] arrInt = {2, 8, -1, 0, 10, 16, 9, 4, 2, -6};
        Arrays.sort(arrInt);
        Arrays.sort(arrInt, 2, 8); //sắp xếp từ vị trí thứ 3 (index 2) đến vị trí thứ 8 (index 7)

        /*
        3. Phương thức binarySearch()
Chức năng: Phương thức binarySearch() giúp tìm kiếm phần tử có giá trị xác định trong mảng đã sắp xếp 
        dựa trên thuật toán binary search nổi tiếng

Return: Trả lại chỉ mục (index) của phần từ đầu tiên bên trái có giá trị cần tìm 
        hoặc trả lại -1 nếu trong mảng không có phần tử cần tìm.

Cú pháp: Arrays.binarySearch(<Tên_mảng>, giá_trị_cần_tìm)

hoặc: Arrays.binarySearch(<Tên_mảng>, start_index, stop_index, giá_trị_cần_tìm)

hoặc: Arrays.binarySearch(<Tên_mảng>, Comparator, giá_trị_cần_tìm)

hoặc: Arrays.binarySearch(<Tên_mảng>, start_index, stop_index, Comparator, giá_trị_cần_tìm)
        Chú ý: Tương tự như khi sử dụng phương thức sort(), khi sử dụng phương thức binarySearch() 
        ta cũng cần chú ý các điểm sau:

Để sử dụng binarySearch() mảng bắt buộc phải được sắp xếp từ trước, 
        nếu không sẽ gây ra lỗi và không thể tìm kiếm được.
Đối với các kiểu dữ liệu nguyên thủy kiểu số như int, long, float, … 
        hoặc với String các bạn có thể sử dụng trực tiếp phương thức binary() mà không cần implement gì thêm.
Để sử dụng phương thức binarySearch() thì mảng phải được sắp xếp 
        và các phần tử trong mảng cũng phải ghi đè phương thức compareTo() của interface Comparable.
Khi tìm kiếm phần tử trong một mảng con của mảng thì khi gọi binary(arr, fromIndex, toIndex, key) 
        thì sẽ chỉ có các phần tử từ fromIndex đến toIndex-1 được tìm kiếm 
        (chứ phần tử ở toIndex không được tính vào).
Phương thức binarySearch() còn cho bạn tùy biến cách so sánh các phần tử trong mảng 
        để đưa ra kết quả sắp xếp tương ứng bằng cách sử dụng Comparator mà mình sẽ đề cập đến trong bài viết khác.
         */
        int[] arrInt1 = {-6, -1, 0, 2, 2, 4, 8, 9, 10, 16};
        int index = Arrays.binarySearch(arrInt1, 4);

        int index1 = Arrays.binarySearch(arrInt, 2, 8, 4); //tìm kiếm phần tử có giá trị 4 từ vị trí thứ 3 (index 2) đến vị trí thứ 8 (index 7)

        /*
        4. Phương thức copyOfRange()
Chức năng: Phương thức copyOfRange() cho phép tạo mảng mới là một mảng con của mảng đã cho.

Cú pháp: Arrays.copyOfRange(<Tên_mảng>, start_index, stop_index)
         */
        int[] arrInt2 = {2, 8, -1, 0, 10, 16, 9, 4, 2, -6};
        int[] arrCopy2 = Arrays.copyOfRange(arrInt, 2, 8);

        /*
        5. Phương thức copyOf()
Chức năng: Phương thức copyOf() cho phép tạo mảng mới có kích thước chỉ định và bao gồm các phần tử của mảng đã cho.

Cú pháp: Arrays.copyOf(<Tên_mảng>, kích_thước_mới)
        Chú ý:

Khi mảng mới có kích thước lớn hơn mảng đã có thì các phần tử ở cuối mảng 
        tính từ vị trí là kích thước mảng cũ sẽ có giá trị mặc định của kiểu của mảng: 
        với kiểu boolean là false, kiểu số là 0, các kiểu tham chiếu là null.
Khi mảng mới có kích thước nhỏ hơn mảng đã có thì các chỉ các phần từ tính từ vị trí 0 đến kích thước mảng mới -1 
        sẽ được copy sang mảng mới.
         */
        int[] arrInt3 = {2, 8, -1, 0, 10, 16, 9, 4, 2, -6};
        int[] arrCopy3 = Arrays.copyOf(arrInt, 15);

        /*
        6. Phương thức fill()
Chức năng: Phương thức fill() cho lấp đầy tất cả các phần tử trong mảng với 1 giá trị xác định.

Cú pháp: Arrays.fill(<Tên_mảng>, giá_trị)

hoặc: Arrays.fill(<Tên_mảng>, start_index, stop_index, giá_trị)
         */
        int[] arrInt4 = new int[10];
        Arrays.fill(arrInt, 1);
        Arrays.fill(arrInt, 2, 8, 1); //chỉ lấp đầy từ index thứ 3 đến thứ 7 với giá trị là 1

        /*
        7. Phương thức equals()
Chức năng: Phương thức equals() thực hiện việc so sánh 2 mảng có bằng nhau hay không.

Return: Kết quả là true nếu 2 mảng có kích thước và các phần tử của 2 mản ở các vị trí giống nhau là bằng nhau 
        và false trong các trường hợp còn lại.

Cú pháp: Arrays.equals(<Tên_mảng_1>, <Tên_mảng_2>)
         */
        int[] arrInt5 = {2, 8, -1, 0, 10, 16, 9, 4, 2, -6};
        int[] arrInt6 = {2, 8, -1, 0, 10, 16, 9, 4, 2, -6};
        int[] arrInt7 = {2, 9, -1, 2, 10, 11, 9, 4, 7, -6};
        Arrays.equals(arrInt5, arrInt6); //kết quả là true

        Arrays.equals(arrInt5, arrInt7); //kết quả là false
    }
}

/*
java.util.Arrays là một lớp đặc biệt trong java, nó bao gồm rất nhiều phương thức (method) dạng static chuyên dụng cho việc thao tác trên mảng như là tìm kiếm và sắp xếp, ngoài ra nó còn bao gồm phương thức cho phép chuyển mảng thành dạng danh sách (list).
 */
