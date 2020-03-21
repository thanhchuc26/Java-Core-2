/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session3_CollectionsAPI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author June
 */
public class treeset {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(5);
        System.out.print("TreeSet: ");
        for (Object i : treeSet) {
            System.out.print(i + " ");
        }
        System.out.println("");
//        HashSet hashSet = new HashSet();
//        hashSet.add(3);
//        hashSet.add(2);
//        hashSet.add(4);
//        hashSet.add(1);
//        hashSet.add(5);
//        for (Object i : hashSet) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//        Iterator iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//        }
    }
}
