/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_Baitap;

import java.io.Serializable;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class Product implements Serializable {

    int ID;
    String name;
    float price;

    public Product() {
    }

    public Product(int ID, String name, float price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public static Product inputInformation() {
        Scanner input = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Input information for Product:");
        System.out.print("ID: ");
        product.ID = input.nextInt();
        System.out.print("Name: ");
        input = new Scanner(System.in);
        product.name = input.nextLine();
        System.out.print("Price: ");
        product.price = input.nextFloat();
        return product;
    }
}
