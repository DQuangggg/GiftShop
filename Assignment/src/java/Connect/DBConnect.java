/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public abstract class DBConnect<T> {

    /**
     *
     */
   protected Connection connection;
   public DBConnect()
   {
       try {
           String user = "quang";
           String pass = "dangquang2001";
           String url = "jdbc:sqlserver://localhost:1433;databaseName=giftShop";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection =    DriverManager.getConnection(url, user, pass);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
    public static void main(String[] args) {
        DBConnect db = new DBConnect() {};
    }
   
}
