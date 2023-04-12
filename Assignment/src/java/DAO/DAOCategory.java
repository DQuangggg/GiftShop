/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Category;
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
public class DAOCategory extends DBConnect {

    public ArrayList<Category> getCategory() {
        ArrayList<Category> listCategory = new ArrayList<>();
        try {
            String sqlquery = "SELECT  [cid]\n"
                    + "      ,[categoryname]\n"
                    + "  FROM [giftShop].[dbo].[Category]";
            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCid(rs.getInt("cid"));
                c.setCategoryName(rs.getString("categoryname"));

                listCategory.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategory;
    }

    public void addCategory(Category c) {
        try {
            String sqlquery = "INSERT INTO Category(categoryname) VALUES (?);";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, c.getCategoryName());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCategory(Category c) {
        try {
            String sql = "UPDATE [Category] SET [categoryname]=?  WHERE [cid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getCategoryName());
            statement.setInt(2, c.getCid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccount(String id) {
        try {
            String sql = "DELETE From [Category] Where cid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Category getCategoryById(String id) {
        try {
            String sqlquery = "Select cid,categoryname From Category \n"
                    + "Where cid like ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + id + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCid(rs.getInt("cid"));
                c.setCategoryName(rs.getString("categoryname"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(cid)as totalcategory From Category";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalaccout = rs.getInt("totalcategory");
                totalPage = totalaccout / pagesize;
                if (totalaccout % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public static void main(String[] args) {
        DAOCategory dao = new DAOCategory();
        System.out.println(dao.getCategory());
    }
}
