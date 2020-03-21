/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_Baitap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOImpl implements ProductDAO {

    public ProductDAOImpl() {
    }

    @Override
    public List<Product> getAllProduct() {
        String sql = "select id, name, price from Product";
        List<Product> listProduct = new ArrayList<>();
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price")));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "insert into Product values(?,?,?)";
        try (Connection connection = connectDB.connectSQLServer(); PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setInt(1, product.getID());
            prepareStatement.setString(2, product.getName());
            prepareStatement.setFloat(3, product.getPrice());
            prepareStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Product getProduct(int ID) {
        String sql = "select id, name, price from Product";
        Product product = null;
        try (Connection connection = connectDB.connectSQLServer(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            if (rs.next()) {
                product = new Product(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

}
