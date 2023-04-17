/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Page;

import DAO.DAOAccount;
import DAO.DAOCategory;
import DAO.DAOProduct;
import Entity.Account;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class changePasswordController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changePasswordController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePasswordController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ArrayList<Product> productsBest = new ArrayList<>();
        DAOProduct pd = new DAOProduct();
        productsBest = pd.get8BestSell();
        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();
        request.setAttribute("listB", productsBest);
        request.setAttribute("listC", listCategory);

        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("userName");
        String pass = request.getParameter("password");
        String newPass = request.getParameter("newPass");
        String confrimPass=  request.getParameter("confrimPass");
        DAOAccount ac = new DAOAccount();
        Account a = ac.getAccounts(user, pass);
        if (a == null) {
            ArrayList<Product> productsBest = new ArrayList<>();
            DAOProduct pd = new DAOProduct();
            productsBest = pd.get8BestSell();
            
            ArrayList<Category> listCategory = new ArrayList<>();
            DAOCategory cd = new DAOCategory();
            listCategory = cd.getCategory();
            
            request.setAttribute("listB", productsBest);
            request.setAttribute("listC", listCategory);
            request.setAttribute("alertMess", "Wrong user or password!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        } else if (newPass.equals(confrimPass) == false) {
            ArrayList<Product> productsBest = new ArrayList<>();
            DAOProduct pd = new DAOProduct();
            productsBest = pd.get8BestSell();
            ArrayList<Category> listCategory = new ArrayList<>();
            DAOCategory cd = new DAOCategory();
            listCategory = cd.getCategory();
            
            request.setAttribute("listB", productsBest);
            request.setAttribute("listC", listCategory);
            request.setAttribute("alertMess", "New password and confrim password must be the same!");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        } else {
            Account acc = new Account();
            acc.setUser(user);
            acc.setPass(newPass);
            ac.updateAccountPassword(acc);
            boolean updatesuccess = true;
            request.setAttribute("updatesuccess", updatesuccess);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
