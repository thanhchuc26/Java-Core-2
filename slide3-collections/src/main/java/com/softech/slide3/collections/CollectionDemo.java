/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide3.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author June
 */
public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        
        System.out.println("List: " + list.toString());
        
        Set<Integer> set = new HashSet<>();
        
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.addAll(list);
        
        System.out.println("Set: " + set.toString());
    }
}
