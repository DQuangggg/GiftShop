/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Contact;
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
public class DAOContact extends DBConnect {

    public ArrayList<Contact> getContact() {
        ArrayList<Contact> listContact = new ArrayList<>();
        try {
            String sqlquery = "SELECT [contactid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[email]\n"
                    + "      ,[phone]\n"
                    + "      ,[message]\n"
                    + "      ,[contactdate]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Contact]"
                    + "  ORDER BY [contactid] DESC";
            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact co = new Contact();
                co.setContactid(rs.getInt("contactid"));
                co.setEmail(rs.getString("email"));
                co.setFirstName(rs.getString("firstname"));
                co.setLastName(rs.getString("lastname"));
                co.setMessage(rs.getString("message"));
                co.setPhone(rs.getString("phone"));
                co.setContactDate(rs.getString("contactdate"));
                co.setStatus(rs.getInt("status"));
                listContact.add(co);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listContact;
    }

    public ArrayList<Contact> getContactById(String id) {
        ArrayList<Contact> listContact = new ArrayList<>();
        try {
            String sqlquery = "SELECT [contactid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[email]\n"
                    + "      ,[phone]\n"
                    + "      ,[message]\n"
                    + "      ,[contactdate]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[Contact]"
                    + "  Where [contactid] like ?\n"
                    + "  ORDER BY contactid DESC";
            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + id + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact co = new Contact();
                co.setContactid(rs.getInt("contactid"));
                co.setFirstName(rs.getString("firstname"));
                co.setLastName(rs.getString("lastname"));
                co.setEmail(rs.getString("email"));
                co.setPhone(rs.getString("phone"));
                co.setMessage(rs.getString("message"));
                co.setContactDate(rs.getString("contactdate"));
                co.setStatus(rs.getInt("status"));
                listContact.add(co);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listContact;
    }

    public void insertContact(Contact con) {
        try {
            String sql = "INSERT INTO Contact(firstname,lastname,email,phone,message,contactdate,status) \n"
                    + "VALUES (?,?,?,?,?,GETDATE(),0);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, con.getFirstName());
            statement.setString(2, con.getLastName());
            statement.setString(3, con.getEmail());
            statement.setString(4, con.getPhone());
            statement.setString(5, con.getMessage());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateContact(Contact con) {
        try {
            String sql = "UPDATE [dbo].[Contact] SET [status] = ? WHERE [contactid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, con.getStatus());
            statement.setInt(2, con.getContactid());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteContact(String id) {
        try {
            String sql = "DELETE From [Contact] Where contactid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalContactPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(contactid)as totalcontact From [Contact]";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalContact = rs.getInt("totalcontact");
                totalPage = totalContact / pagesize;
                if (totalContact % pagesize != 0) {
                    totalPage++;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public ArrayList<Contact> getListContactWithPage(int index, int pagesize) {
        ArrayList<Contact> listContact = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT [contactid]\n"
                    + "      ,[firstname]\n"
                    + "      ,[lastname]\n"
                    + "      ,[email]\n"
                    + "      ,[phone]\n"
                    + "      ,[message]\n"
                    + "      ,[contactdate]\n"
                    + "      ,[status], ROW_NUMBER() OVER(ORDER BY [contactid]) RN\n"
                    + "  FROM [giftShop].[dbo].[Contact]\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ? ORDER BY contactid DESC";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize - 1));
            statement.setInt(2, index * pagesize);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Contact c = new Contact();
                c.setContactid(rs.getInt("contactid"));
                c.setFirstName(rs.getString("firstname"));
                c.setLastName(rs.getString("lastname"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setMessage(rs.getString("message"));
                c.setContactDate(rs.getString("contactdate"));
                c.setStatus(rs.getInt("status"));
                listContact.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOContact.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listContact;
    }

    public static void main(String[] args) {
        DAOContact dao = new DAOContact();
        System.out.println(dao.getContactById(""));
        //dao.updateContact(new Contact(3, "", "", "", "", "", "", 1));
    }
}
