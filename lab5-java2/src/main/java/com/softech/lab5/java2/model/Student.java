/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab5.java2.model;

import java.io.Serializable;

/**
 *
 * @author June
 */
public class Student implements Serializable{
    private String name;
    private float mark;
    private String major;

    public Student() {
    }

    public Student(String name, float mark, String major) {
        this.name = name;
        this.mark = mark;
        this.major = major;
    }

    public String getGrade(){
        if(mark > 9)
            return "Xuat sac";
        return "Gioi";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
}
