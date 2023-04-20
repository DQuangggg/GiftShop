/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Account;
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
public class DAOAccount extends DBConnect {

    //add Account with role = not admin
    public void addAccount(Account a) {
        try {
            String sqlquery = "INSERT INTO Account(username, password, isAdmin) VALUES (?, ?, 0);";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, a.getUser());
            statement.setString(2, a.getPass());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add Account with role = admin or not
    public void addAccountByAdmin(Account a) {
        try {
            String sqlquery = "INSERT INTO Account(username, [password], isAdmin) VALUES (?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, a.getUser());
            statement.setString(2, a.getPass());
            statement.setBoolean(3, a.isIsAdmin());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAccount(Account a) {
        try {
            String sql = "UPDATE [Account] SET [password]=?, [isAdmin]=?   WHERE [aid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, a.getPass());
            statement.setBoolean(2, a.isIsAdmin());
            statement.setInt(3, a.getAid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAccountPassword(Account a) {
        try {
            String sql = "UPDATE [Account] SET [password]=?   WHERE [username] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, a.getPass());
            statement.setString(2, a.getUser());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccount(String id) {
        try {
            String sql = "DELETE From [Account] Where aid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //get Account
    public Account getAccounts(String user, String pass) {
        try {
            String sqlquery = "Select aid,username,password,isAdmin From Account \n"
                    + "Where username = ? and password = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account checkAccountsExist(String user) {
        try {
            String sqlquery = "Select aid,username,password,isAdmin From Account \n"
                    + "Where username = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, user);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account getAccountsById(String id) {
        try {
            String sqlquery = "Select aid,username,password,isAdmin From Account \n"
                    + "Where aid like ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + id + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Account> getAccountsByName(String name) {
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            String sqlquery = "Select aid,username,password,isAdmin From Account \n"
                    + "Where username like ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                listAccount.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccount;
    }
    
        public ArrayList<Account> getAccountsByRole(int isAdmin) {
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            String sqlquery = "Select aid,username,password,isAdmin From Account \n"
                    + "Where isAdmin = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1,isAdmin);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                listAccount.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccount;
    }

    public int getTotalPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(aid)as totalaccout From Account";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalaccout = rs.getInt("totalaccout");
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

    public ArrayList<Account> getListAccountsWithPage(int index, int pagesize) {
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT   [aid]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[isAdmin], ROW_NUMBER() OVER(ORDER BY [aid]) RN\n"
                    + "   FROM [giftShop].[dbo]. [Account]\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize - 1));
            statement.setInt(2, index * pagesize);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setAid(rs.getInt("aid"));
                a.setUser(rs.getString("username"));
                a.setPass(rs.getString("password"));
                a.setIsAdmin(rs.getBoolean("isAdmin"));
                listAccount.add(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccount;
    }

    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
        System.out.println(dao.getAccountsByRole(1));
    }
}
