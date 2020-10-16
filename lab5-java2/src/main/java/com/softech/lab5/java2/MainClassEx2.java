/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab5.java2;

import com.softech.lab5.java2.model.Student;
import utils.XFile;

/**
 *
 * @author June
 */
public class MainClassEx2 {
    public static void main(String[] args) {
        try {
            Student s = new Student("Chuc", 10, "Programing");
            String path = "G:/FileDemo/Students.dat";
            
            XFile.writeObject(path, s);
            Student std = (Student)XFile.readObject(path);
            System.out.println("Name: " + s.getName());
            System.out.println("Mark: " + s.getMark());
            System.out.println("Major: " + s.getMajor());
            System.out.println("Grade: " + s.getGrade());
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
