/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_Baitap;

import java.util.List;

/**
 *
 * @author June
 */
public interface ProductDAO {

    List<Product> getAllProduct();

    void addProduct(Product product);

    Product getProduct(int ID);
}
