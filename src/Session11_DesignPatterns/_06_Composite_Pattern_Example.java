/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

import java.util.ArrayList;

/**
 *
 * @author June
 */
abstract class TaskItem {

    public abstract double getTime();
}

class Task extends TaskItem {

    String name;
    double time;

    public Task() {
    }

    public Task(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}

class Project extends TaskItem {

    String name;
    ArrayList<TaskItem> listTaskItems = new ArrayList<>();

    public Project() {
    }

    public Project(String name, ArrayList<TaskItem> listTaskItems) {
        this.name = name;
        this.listTaskItems = listTaskItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TaskItem> getListTaskItems() {
        return listTaskItems;
    }

    public void setListTaskItems(ArrayList<TaskItem> listTaskItems) {
        this.listTaskItems = listTaskItems;
    }

    @Override
    public double getTime() {
        double time = 0;
        for (TaskItem listTaskItem : listTaskItems) {
            time += listTaskItem.getTime();
        }
        return time;
    }

    public void addTask(TaskItem taskItem) {
        if (!listTaskItems.contains(taskItem)) {
            listTaskItems.add(taskItem);
        }
    }

    public void removeTask(TaskItem taskItem) {
        listTaskItems.remove(taskItem);
    }
}

public class _06_Composite_Pattern_Example {

    public static void main(String[] args) {
        Task task1 = new Task("thi ly thuyet", 45);
        Task task2 = new Task("thi thuc hanh", 60);
        ArrayList<TaskItem> listTaskItems = new ArrayList<>();
        listTaskItems.add(task1);
        listTaskItems.add(task2);
        Project project = new Project("Thoi gian thi", listTaskItems);
        System.out.println("Tong thoi gian " + task1.getName() + " va " + task2.getName() + " la: " + project.getTime());
    }
}

/*
Composite Pattern là một mẫu cấu trúc (Structural Pattern).

Composite Pattern cho phép tương tác với tất cả các đối tượng tương tự nhau giống như là các đối tượng đơn hoặc collections.

Ví dụ: Đối tượng File sẽ là 1 đối tượng đơn nếu bên trong nó không có file nào khác, nhưng đối tượng file sẽ được đối xử giống như 1 collections nếu bên trong nó lại có những File khác.

Khi tính kích thước của File ta sẽ cần tính kích thước của tất cả các file bên trong nó.

Component (Thành phần):
Khai báo interface hoặc abstract chung cho các thành phần đối tượng.
Chứa các method thao tác chung của các thành phần đối tượng.

Leaf (Lá):
Biểu diễn các đối tượng lá (ko có con) trong thành phần đối tượng.

Composite (Hỗn hợp):
Định nghĩa một thao tác cho các thành phần có thành phần con.
Lưu trữ thành phần con.
Thực thi sự quản lý các thành phần con của giao diện Component.

Ví dụ.
1 project là 1 tập hợp nhiều tác vụ (Task) con, đồng thời bản thân project cũng là 1 task lớn.
Ta cần tính tống thời gian của project thông qua thời gian của các task con.
 */
