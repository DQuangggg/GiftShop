/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Product {
    int pid;
    String productName;
    String productImg;
    int productPrice;
    String productNote;
    int cid;

    public Product() {
    }

    public Product(int pid, String productName, String productImg, int productPrice, String productNote, int cid) {
        this.pid = pid;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productNote = productNote;
        this.cid = cid;
    }

   
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductNote() {
        return productNote;
    }

    public void setProductNote(String productNote) {
        this.productNote = productNote;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", productName=" + productName + ", productImg=" + productImg + ", productPrice=" + productPrice + ", productNote=" + productNote + ", cid=" + cid + '}';
    }


    
}
