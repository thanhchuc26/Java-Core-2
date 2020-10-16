/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.slide3.collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author June
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        
        map.put("Samsung", 200.0);
        map.put("Sony", 400.0);
        map.put("LG", 100.0);
        map.put("Nokia", 500.00);
        
        System.out.println("Map: " + map.toString());
        map.put("Samsung", 1000d);
        System.out.println("Map: " + map.toString());
        for (Map.Entry<String, Double> item: map.entrySet()) {
            System.out.print("Key: " + item.getKey());
            System.out.println(" - Value: " + item.getValue());
        }
    }
}
