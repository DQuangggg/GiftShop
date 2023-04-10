/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Order {
    int orderid;
    int custid;
    Date orderDate;
    int status;

    public Order() {
    }

    public Order(int orderid, int custid, Date orderDate, int status) {
        this.orderid = orderid;
        this.custid = custid;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", custid=" + custid + ", orderDate=" + orderDate + ", status=" + status + '}';
    }

    
}
