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
class classJob {

    private String role;
    private long salary;
    private int id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class classPerson {

    //COMPOSITION cho mối quan hệ người có-một việc ( has - a)
    private classJob job;

    public classPerson() {
        this.job = new classJob();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }

}

public class Composition_pattern_Example {

    public static void main(String[] args) {
        classPerson person = new classPerson();
        long salary = person.getSalary();
        System.out.println("Salary of person: " + salary);
    }
}

/*
Composition - tạm dịch là tổng hợp - là một kỹ thuật design.

Để thực hiện kỹ thuật Composition, ta cần sử dụng các object ở một class khác 
làm thuộc tính cho object được tạo bởi class tổng hợp. 

Composition được sinh ra nhằm đạt được mục đích là implement mối quan hệ có-một (has-a) giữa các class. 
Quan hệ has-a của 2 class tức là trong quá trình xây dựng class, 
class này có tham chiếu đến class khác (xem như là thành viên của nó).

Ta áp dụng Composition khi cần sử dụng những chức năng của một class 
nhưng lại không muốn tác động lên phần code của class đó.

Hãy xét ví dụ về 2 class: Person và Job. Person đại diện cho người, Job đại diện công việc. 
Mỗi người sẽ có một công việc, và trong class test, chúng ta sẽ xuất ra tiền lương của người đó.
*/
