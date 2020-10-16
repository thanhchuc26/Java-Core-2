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
public class NoTaxProduct extends Product{
    
    @Override
    public double getImportTax(){
        return 0;
    }
}
