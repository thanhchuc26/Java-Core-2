/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_Baitap;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author June
 */
public class ProductApp {

    private static void case1() {
        Product product = Product.inputInformation();
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        productDAOImpl.addProduct(product);
        System.out.println("Add new Product to database success.");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    private static void case2() {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        List<Product> listProducts = productDAOImpl.getAllProduct();
        if (listProducts.isEmpty()) {
            System.out.println("Products list: Empty");
            System.out.println("Press any key to continue.");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        } else {
            System.out.println("Products list:");
            for (int i = 0; i < listProducts.size(); i++) {
                System.out.println("\tProduct " + (i + 1) + ": ");
                System.out.println("\t\tID: " + listProducts.get(i).getID());
                System.out.println("\t\tName: " + listProducts.get(i).getName());
                System.out.println("\t\tPrice: " + listProducts.get(i).getPrice());
            }
            System.out.println("Press any key to continue.");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

    private static void case3() throws FileNotFoundException, IOException {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        List<Product> listProducts = productDAOImpl.getAllProduct();
        if (listProducts.isEmpty()) {
            System.out.println("Products list: Empty");
            System.out.println("Press any key to continue.");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        } else {
            File file = new File("");
            file = new File(file.getAbsolutePath() + "/src/session11_baitap/Product.dat");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                for (Product product : listProducts) {
                    objectOutputStream.writeObject(product);
                }
            }
            System.out.println("Save all products in file Product.dat success.");
            System.out.println("Press any key to continue.");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

    private static void case4() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("");
        file = new File(file.getAbsolutePath() + "/src/session11_baitap/Product.dat");
        List<Product> listProducts = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            do {
                try {
                    listProducts.add((Product) objectInputStream.readObject());
                } catch (EOFException error) {
                    break;
                }
            } while (true);
        }
        if (listProducts.isEmpty()) {
            System.out.println("Products list: Empty");
            System.out.println("Press any key to continue.");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        } else {
            System.out.println("Products list:");
            for (int i = 0; i < listProducts.size(); i++) {
                System.out.println("\tProduct " + (i + 1) + ": ");
                System.out.println("\t\tID: " + listProducts.get(i).getID());
                System.out.println("\t\tName: " + listProducts.get(i).getName());
                System.out.println("\t\tPrice: " + listProducts.get(i).getPrice());
            }
            System.out.println("Press any key to continue.");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        do {
            System.out.println("==========MENU==========");
            System.out.println("1. Add product");
            System.out.println("2. Show products list");
            System.out.println("3. Save all products in an object file.");
            System.out.println("4. Load file and show products list.");
            System.out.println("5. Exit program.");
            System.out.print("Enter your choose: ");
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
