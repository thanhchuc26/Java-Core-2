/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author June
 */
class Student1 implements Comparable<Student1>{
    private String name;

    public Student1() {
    }

    public Student1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student1 t) {
        if(this.getName().compareToIgnoreCase(t.getName())==0){
            return 0;
        }
        else{
            if(this.getName().compareToIgnoreCase(t.getName())>0){
            return 1;
        }
            else{
                return -1;
            }
        }
    }
    
}
public class _15_Comparable_Example {
    public static void main(String[] args) {
        ArrayList<Student1> myArrayList = new ArrayList<>();
        Student1 student1 = new Student1("a");
        Student1 student2 = new Student1("c");
        Student1 student3 = new Student1("b");
        myArrayList.add(student1);
        myArrayList.add(student2);
        myArrayList.add(student3);
        Collections.sort(myArrayList);
        for (Student1 student : myArrayList) {
            System.out.println("Student name: " + student.getName());
        }
    }
}
