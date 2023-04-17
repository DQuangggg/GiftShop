/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Order;

import DAO.DAOCategory;
import DAO.DAOCustomer;
import DAO.DAOOrder;
import Entity.Category;
import Entity.Customer;
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
public class managerOrderController extends HttpServlet {
   
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
            out.println("<title>Servlet managerOrderController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managerOrderController at " + request.getContextPath () + "</h1>");
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
        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();
        DAOOrder od = new DAOOrder();
        
        ArrayList<Customer> listCustomer = new ArrayList<>();
        DAOCustomer cu = new DAOCustomer();
        listCustomer = cu.getCustomers();
        

        int totalPage = 0;
        int pagesize = 20;
        totalPage = od.getTotalOrderPage(pagesize);
        String pageCurrent = request.getParameter("page");
        int pageC = 0;
        if (pageCurrent == null) {
            pageC = 1;
        } else {
            pageC = Integer.parseInt(pageCurrent);

        }
        ArrayList<Order> listOrder = new ArrayList<>();
        listOrder = od.getListOrderWithPage(pageC, pagesize);
        request.setAttribute("listC", listCategory);
        request.setAttribute("listO", listOrder);
        request.setAttribute("listCU", listCustomer);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageCurrent", pageC);
        request.getRequestDispatcher("managerOrder.jsp").forward(request, response);
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
    throws ServletException, IOException {String oidString = request.getParameter("oid");
        String status = request.getParameter("status");
        DAOOrder od = new DAOOrder();
        Order o = new Order();
        ArrayList<Category> listCategory = new ArrayList<>();
        ArrayList<Order> listOrder = new ArrayList<>();
        ArrayList<Order> listStatus = new ArrayList<>();
        ArrayList<Customer> listCustomer = new ArrayList<>();
        listOrder = od.getOrdersById(oidString);
        listOrder = od.getOrdersByStatus(status);
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();
        DAOCustomer cud = new DAOCustomer();
        listCustomer = cud.getCustomers();
        listOrder.add(o);
        request.setAttribute("searchMessage", oidString);
        request.setAttribute("searchByStatus", status);
        request.setAttribute("listO", listOrder);
        request.setAttribute("listC", listCategory);
        request.setAttribute("listCU", listCustomer);
        request.getRequestDispatcher("managerOrder.jsp").forward(request, response);processRequest(request, response);
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
