/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Account {
    int aid;
    String user;
    String pass;
    boolean isAdmin;

    public Account() {
    }

    public Account(int aid, String user, String pass, boolean isAdmin) {
        this.aid = aid;
        this.user = user;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "aid=" + aid + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + '}';
    }
    
    
}