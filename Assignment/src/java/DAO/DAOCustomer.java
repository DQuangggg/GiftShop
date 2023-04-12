/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Customer;
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
public class DAOCustomer extends DBConnect {

    public Customer getCustomer(Customer cust) {
        try {
            String sql = "SELECT [custid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[address]\n"
                    + "      ,[city]\n"
                    + "      ,[phone]\n"
                    + "  FROM [giftShop].[dbo].[Customer]\n"
                    + "  \n"
                    + "  Where [firstname]=?  and [lastname] =? and [address] = ? and [city] =? and [phone]=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cust.getFirstname());
            statement.setString(2, cust.getLastname());
            statement.setString(3, cust.getAddress());
            statement.setString(4, cust.getCity());
            statement.setString(5, cust.getPhone());

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setCustid(rs.getInt("custid"));
                c.setFirstname(rs.getString("firstname"));
                c.setLastname(rs.getString("lastname"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setPhone(rs.getString("phone"));

                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getLastIdOfCustomer() {
        int lastCustId = 0;
        try {
            String sql = "Select TOP 1 custid From Customer\n"
                    + "Order By custid Desc";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                lastCustId = rs.getInt("custid");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastCustId;
    }

    public Customer getCustomerById(int id) {
        try {
            String sql = "SELECT [custid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[address]\n"
                    + "      ,[city]\n"
                    + "      ,[phone]\n"
                    + "  FROM [giftShop].[dbo].[Customer]\n"
                    + "  \n"
                    + "  Where [custid]=? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setCustid(rs.getInt("custid"));
                c.setFirstname(rs.getString("firstname"));
                c.setLastname(rs.getString("lastname"));
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setPhone(rs.getString("phone"));

                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertCustomer(Customer cust) {
        try {
            String sql = "INSERT INTO Customer(firstname,lastname,address,city,phone)\n"
                    + "values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cust.getFirstname());
            statement.setString(2, cust.getLastname());
            statement.setString(3, cust.getAddress());
            statement.setString(4, cust.getCity());
            statement.setString(5, cust.getPhone());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try {
            String sql = "SELECT [custid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[address]\n"
                    + "      ,[city]\n"
                    + "      ,[phone]\n"
                    + "  FROM [giftShop].[dbo].[Customer]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer cu = new Customer();
                cu.setCustid(rs.getInt("custid"));
                cu.setFirstname(rs.getString("firstname"));
                cu.setLastname(rs.getString("lastname"));
                cu.setAddress(rs.getString("address"));
                cu.setCity(rs.getString("city"));
                cu.setPhone(rs.getString("phone"));
                listCustomer.add(cu);
            }
        } catch (Exception e) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, e);
        }
        return listCustomer;
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
        System.out.println(dao.getCustomers());
    }
}
