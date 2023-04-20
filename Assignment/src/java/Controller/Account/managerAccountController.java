/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Account;

import DAO.DAOAccount;
import DAO.DAOCategory;
import Entity.Account;
import Entity.Category;
import Entity.Order;
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
public class managerAccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOCategory cd = new DAOCategory();
        ArrayList<Category> listCategory = new ArrayList<>();
        listCategory = cd.getCategory();

        DAOAccount ad = new DAOAccount();

        int totalPage = 0;
        int pagesize = 10;
        totalPage = ad.getTotalPage(pagesize);
        String pageCurrent = request.getParameter("page");
        int pageC = 0;
        if (pageCurrent == null) {
            pageC = 1;
        } else {
            pageC = Integer.parseInt(pageCurrent);
        }

        String statusParam = request.getParameter("role");
        int role = (statusParam != null && !statusParam.isEmpty()) ? Integer.parseInt(statusParam) : -1;
        ArrayList<Account> accounts = new ArrayList<>();
        if (role == -1) {
            accounts = ad.getListAccountsWithPage(pageC, pagesize);
        } else {
            accounts = ad.getAccountsByRole(role);
        }


        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageCurrent", pageC);
        request.setAttribute("listA", accounts);
        request.setAttribute("listC", listCategory);

        request.getRequestDispatcher("managerAccount.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aidString = request.getParameter("aid");
        DAOAccount ad = new DAOAccount();
        ArrayList<Account> listAccount = new ArrayList<>();
        listAccount = ad.getAccountsByName(aidString);

        Account a = new Account();
        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();
        listAccount.add(a);
        request.setAttribute("searchMessage", aidString);
        request.setAttribute("listA", listAccount);
        request.setAttribute("listC", listCategory);
        request.getRequestDispatcher("managerAccount.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
