/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

/**
 *
 * @author June
 */
class TestGC {

    int num1;
    int num2;

    public void setNum(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void showNum() {
        System.out.println("Value of num1 is " + num1);
        System.out.println("Value of num2 is " + num2);
    }
}

public class Garbage_collection {

    public static void main(String[] args) {
        TestGC obj1 = new TestGC();
        TestGC obj2 = new TestGC();
        obj1.setNum(2, 3);
        obj2.setNum(4, 5);
        obj1.showNum();
        obj2.showNum();
        TestGC obj3; // line 1
        obj3 = obj2; // line 2
        obj3.showNum(); // line 3
        obj2 = null; // line 4
        obj2.showNum(); // line 5
        obj3 = null; // line 6
        obj3.showNum(); // line 7
    }
}

//Đoạn mã cho thấy lớp có tên TestGC gồm hai biến được khởi tạo trong phương thức setNum() 
//và được hiển thị sử dụng phương thức showNum().
//Tiếp đến, hai đối tượng obj1 và obj2 của lớp TestGC được tạo. 
//Bây giờ, để hiểu được việc thu dọn rác thì ta thực thi đoạn mã trên.
//Bây giờ, nếu bỏ chú thích ở các câu lệnh tại các dòng 1, 2 và 3 đi và chạy lại chương trình thì
//hai biến tham chiếu sẽ trỏ tới cùng một đối tượng.
//Tiếp theo, khi bỏ chú thích ở dòng 4 và 5 đi và thực hiện lại chương trình, thì obj2 trở thành
//null, nhưng obj3 vẫn trỏ tới đối tượng. Do đó, đối tượng vẫn chưa hội đủ điều kiện để trở thành
//rác.
//Bây giờ, ta bỏ chú thích dòng 6 và 7 đi và chạy lại chương trình thì obj2 cũng trở thành
//null. Lúc này thì không còn tham chiếu nào trỏ tới đối tượng nữa và vì vậy, nó đủ điều kiện để
//trở thành rác. Nó sẽ bị hủy khỏi bộ nhớ và không thể được truy xuất lại.
//Như vậy, ta có một số điều quan trọng về việc dọn rác trong Java như sau:
//­ Để biến một đối tượng thành rác, thì đặt biến tham chiếu của nó là null.
//­ Cần lưu ý rằng, các kiểu nguyên thủy không phải là các đối tượng. Vì thế, chúng không thể
//được gán là null, ví dụ như int x = null; là sai.
