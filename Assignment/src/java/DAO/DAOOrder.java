/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOOrder extends DBConnect {

    public ArrayList<Order> getListOrder() {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT [orderid]\n"
                    + "      ,[custid]\n"
                    + "      ,[orderdate]\n"
                    + "      ,[status]\n"
                    + "  FROM [giftShop].[dbo].[Order]";

            PreparedStatement statement = connection.prepareStatement(sqlquery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setOrderDate(rs.getDate("orderdate"));
                o.setStatus(rs.getInt("status"));
                listOrder.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public ArrayList<Order> getOrdersById(String id) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT [orderid] ,a.[custid]  ,[orderdate] ,[status] FROM [giftShop].[dbo].[Order] a inner join \n"
                    + "[giftShop].[dbo].[Customer] b on a.custid = b.custid Where orderid like ?  ORDER BY orderid DESC";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + id + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setOrderDate(rs.getDate("orderdate"));
                o.setStatus(rs.getInt("status"));
                listOrder.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public ArrayList<Order> getOrdersByStatus(int status) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT [orderid] ,a.[custid]  ,[orderdate] ,[status] FROM [giftShop].[dbo].[Order] a inner join \n"
                    + "[giftShop].[dbo].[Customer] b on a.custid = b.custid Where a.status = ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, status);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setOrderDate(rs.getDate("orderdate"));
                o.setStatus(rs.getInt("status"));
                listOrder.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public int getLastIdOfOrder() {
        int lastOrderId = 0;
        try {
            String sql = "Select TOP 1 orderid From [Order]\n"
                    + "Order By orderid Desc";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                lastOrderId = rs.getInt("orderid");
                return lastOrderId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastOrderId;
    }

    public void insertOrder(Order o) {
        try {
            String sql = "INSERT INTO [Order](custid,orderdate,status) VALUES (?,?,0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, o.getCustid());
            statement.setDate(2, o.getOrderDate());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalOrderPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(orderid)as totalorder From [Order]";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalOrder = rs.getInt("totalorder");
                totalPage = totalOrder / pagesize;
                if (totalOrder % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public ArrayList<Order> getListOrderWithPage(int index, int pagesize) {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT [orderid]\n"
                    + "      ,[custid]\n"
                    + "      ,[status]\n"
                    + "      ,[orderdate], ROW_NUMBER() OVER(ORDER BY [orderid]) RN\n"
                    + "  FROM [giftShop].[dbo].[Order]\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ? Order by orderid DESC";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize - 1));
            statement.setInt(2, index * pagesize);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setOrderDate(rs.getDate("orderdate"));
                o.setStatus(rs.getInt("status"));
                listOrder.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public ArrayList<Order> getListOrderDetails() {
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sqlquery = "SELECT c.orderid , p.productname , p.productimg , p.productprice , c.amount , o.orderdate ,\n"
                    + "		 cu.firstname + '' + cu.lastname as FullName , cu.address , cu.city , cu.phone\n"
                    + "		 FROM [Cart] c inner join Product p on c.pid = p.pid\n"
                    + "					   inner join [Order] o on c.orderid = o.orderid\n"
                    + "					   inner join [Customer] cu on o.custid = cu.custid\n"
                    + "					   WHERE c.orderid = 16";

            PreparedStatement statement = connection.prepareStatement(sqlquery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setOrderDate(rs.getDate("orderdate"));
                listOrder.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    public void updateOrder(Order order) {
        try {
            String sql = "UPDATE [dbo].[Order] SET [status] = ? WHERE [orderid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getStatus());
            statement.setInt(2, order.getOrderid());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalOrder() {
        try {
            String sql = "SELECT COUNT(*) From [Order]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (SQLException ex) {

        }
        return 0;
    }

    public List<Order> pagingOrder(int index) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Order] ORDER BY orderid  OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 15);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("orderid"));
                o.setCustid(rs.getInt("custid"));
                o.setOrderDate(rs.getDate("orderdate"));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
        //System.out.println(dao.getTotalOrder());
        List<Order> list = dao.pagingOrder(0);
        for (Order product : list) {
            System.out.println(product);
        }
    }
}
