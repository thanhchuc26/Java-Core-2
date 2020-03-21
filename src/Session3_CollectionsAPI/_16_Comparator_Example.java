/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author June
 */
class Student implements Comparator<Student> {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Student t, Student t1) {
        if (t.getName().compareToIgnoreCase(t1.getName()) == 0) {
            return 0;
        } else {
            if (t.getName().compareToIgnoreCase(t1.getName()) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}

public class _16_Comparator_Example {

    public static void main(String[] args) {
        ArrayList<Student> myArrayList = new ArrayList<>();
        Student student1 = new Student("a");
        Student student2 = new Student("c");
        Student student3 = new Student("b");
        myArrayList.add(student1);
        myArrayList.add(student2);
        myArrayList.add(student3);
        Collections.sort(myArrayList, new Student());
        for (Student student : myArrayList) {
            System.out.println("Student name: " + student.getName());
        }
    }
}
