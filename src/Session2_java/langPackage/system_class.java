/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.util.Properties;

/**
 *
 * @author June
 */
public class system_class {

    static void arraycopyExample() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{6, 7, 8, 9, 10};
        System.out.print("arr1: ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        System.out.println("");
        System.out.print("arr2: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println("");
        // static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length): coppy mảng
        System.arraycopy(arr1, 0, arr2, 0, 2); //copy từ phần tử thứ 0 của arr1 vào arr2 2 phần tử từ phần tử thứ 0
        System.out.print("arr2 sau khi dùng System.arraycopy từ arr1: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    static void currentTimeMillisExample() {
        // static long currentTimeMillis(): lấy thời gian hiện tại theo mili giây
        long start = System.currentTimeMillis();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.print("Các phần tử của arr: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        long stop = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Tổng thời gian thực hiện của chương trình là: " + (stop - start) + " mili giây");
    }
static void getenvExample(){
    // static String getenv(String name): lấy thông tin của các biến môi trường (Get Environment Cariable)
    // gets the value of the specified environment variable "PATH"
      System.out.println("System.getenv(\"PATH\") = ");
      System.out.println(System.getenv("PATH"));

      // gets the value of the specified environment variable "TEMP"
      System.out.print("System.getenv(\"TEMP\") = ");
      System.out.println(System.getenv("TEMP"));

      // gets the value of the specified environment variable "USERNAME"
      System.out.print("System.getenv(\"USERNAME\") = ");
      System.out.println(System.getenv("USERNAME"));
}
static void getPropertiesExample(){
    // static Properties getProperties(): lấy các thuộc tính của môi trường java
    Properties myProperties = System.getProperties(); // myProperties là 1 danh sách chứa các thuộc tính
      myProperties.list(System.out);
      
      // có thể lấy riêng từng thuộc tính trong myProperties như sau:
      System.out.println("sun.cpu.isalist là: "+myProperties.getProperty("sun.cpu.isalist"));
}
    public static void main(String[] args) {
//        arraycopyExample();
//        currentTimeMillisExample();
//        getenvExample();
        getPropertiesExample();
        
    }
}
