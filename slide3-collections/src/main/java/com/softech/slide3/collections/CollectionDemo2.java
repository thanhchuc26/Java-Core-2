/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide3.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author June
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(9);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(12);
        list.add(44);
        list.add(3);
        
        System.out.println("List: " + list.toString());
       
        Collections.sort(list);
        System.out.println("List after sorted in ascending: " + list.toString());

        Collections.shuffle(list);
        System.out.println("List shuffle: " + list.toString());

        Collections.sort(list, (a, b)-> b - a);
        System.out.println("List after sorted in descending: " + list.toString());        
        Collections.sort(list);
        if(Collections.binarySearch(list, 12) >=0) // muon su dung Binary search thi list phai duoc sap xep tang dan truoc
            System.out.println("12 in list");
        else
            System.out.println("12 not in list");
    }
}
