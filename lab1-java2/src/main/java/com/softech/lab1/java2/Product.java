/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.lab1.java2;

/**
 *
 * @author June
 */
public class Product implements DAO{

    private String name;
    private float price;

    public Product() {
        name = "";
        price = 0;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getImportTax() {
        return price * 0.1;
    }

    @Override
    public void insert() {
        System.out.println("Insert successfully");
    }

    @Override
    public void update() {
        System.out.println("Update successfully");
    }

    @Override
    public void delete() {
        System.out.println("Delete successfully");
    }

    @Override
    public void select() {
        System.out.println("Select successfully");
    }

}
