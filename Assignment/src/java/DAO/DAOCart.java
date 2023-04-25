/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Cart;
import Entity.Order;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOCart extends DBConnect {

     public ArrayList<Cart> getCarts() {
        ArrayList<Cart> carts = new ArrayList<>();
        try {
            String sqlquery = "SELECT * FROM [Cart]";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cart c = new Cart();
                c.setCartid(rs.getInt("orderid"));
                c.setAmount(rs.getInt("amount"));
                Product p = new Product();
                p.setProductName(rs.getString("productName"));
                p.setProductImg(rs.getString("productImg"));
                p.setProductPrice(rs.getInt("productPrice"));
                c.setProduct(p);
                carts.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carts;
    }
    
    public int getIdOfLastCart() {
        int lastCartId = 0;
        try {
            String sql = "Select TOP 1 cartid From Cart\n"
                    + "Order By cartid Desc";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                lastCartId = rs.getInt("cartid");
                return lastCartId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastCartId;
    }

    public void insertCart(Cart cart) {
        try {
            String sql = "Insert Into Cart (orderid,pid,amount)\n"
                    + "Values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cart.getCartid());
            statement.setInt(2, cart.getProduct().getPid());
            statement.setInt(3, cart.getAmount());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cart getCartById(String id) {
        try {
            String sql = "SELECT c.orderid ,p.pid, p.productname , p.productimg , p.productprice , c.amount , o.orderdate \n"
                    + "       FROM [Cart] c inner join Product p on c.pid = p.pid\n"
                    + "                     inner join [Order] o on c.orderid = o.orderid\n"
                    + "       WHERE c.orderid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setCartid(rs.getInt("orderid"));
                c.setAmount(rs.getInt("amount"));
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productName"));
                p.setProductImg(rs.getString("productImg"));
                p.setProductPrice(rs.getInt("productPrice"));
                c.setProduct(p);
                Order o = new Order();
                o.setOrderDate(rs.getDate("orderdate"));
                return c;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Cart> getCartByIds(String id) {
         ArrayList<Cart> carts = new ArrayList<>();
        try {
            String sql = "SELECT c.orderid ,p.pid, p.productname , p.productimg , p.productprice , c.amount , o.orderdate \n"
                    + "       FROM [Cart] c inner join Product p on c.pid = p.pid\n"
                    + "                     inner join [Order] o on c.orderid = o.orderid\n"
                    + "       WHERE c.orderid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setCartid(rs.getInt("orderid"));
                c.setAmount(rs.getInt("amount"));
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productName"));
                p.setProductImg(rs.getString("productImg"));
                p.setProductPrice(rs.getInt("productPrice"));
                c.setProduct(p);
                Order o = new Order();
                o.setOrderDate(rs.getDate("orderdate"));
                carts.add(c);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carts;
    }

    public static void main(String[] args) {
        DAOCart c = new DAOCart();
        System.out.println(c.getCartByIds("16"));
    }
}
