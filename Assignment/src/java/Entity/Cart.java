/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Cart {
    int cartid;
    Product product;
    int amount;

    public Cart() {
    }

    public Cart(int cartid, Product product, int amount) {
        this.cartid = cartid;
        this.product = product;
        this.amount = amount;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartid=" + cartid + ", product=" + product + ", amount=" + amount + '}';
    }
    
    
}

