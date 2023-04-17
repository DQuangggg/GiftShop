/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Order;

import DAO.DAOCart;
import DAO.DAOCategory;
import DAO.DAOCustomer;
import DAO.DAOOrder;
import DAO.DAOProduct;
import Entity.Cart;
import Entity.Category;
import Entity.Customer;
import Entity.Order;
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
public class managerOrderDetailsController extends HttpServlet {
   
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
            out.println("<title>Servlet managerOrderDetailsController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managerOrderDetailsController at " + request.getContextPath () + "</h1>");
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
        String cartidString = request.getParameter("cartid");
        int cartid = Integer.parseInt(cartidString);
        DAOCart cd = new DAOCart();
        Cart c = new Cart();
        c = cd.getCartById(cartidString);

        ArrayList<Product> listProduct = new ArrayList<>();
        DAOProduct dp = new DAOProduct();
        listProduct = dp.getProducts();

        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cad = new DAOCategory();
        listCategory = cad.getCategory();
        
        ArrayList<Order> listOrder = new ArrayList<>();
        DAOOrder od = new DAOOrder();
        listOrder = od.getListOrder();
        
        ArrayList<Customer> listCustomer = new ArrayList<>();
        DAOCustomer cud = new DAOCustomer();
        listCustomer = cud.getCustomers();
        
        request.setAttribute("listP", listProduct);
        request.setAttribute("listC", listCategory);
        request.setAttribute("listO", listOrder);
        request.setAttribute("listCU", listCustomer);
        request.setAttribute("cart", c);
        request.getRequestDispatcher("managerOrderDetails.jsp").forward(request, response);
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
        String orderidString = request.getParameter("orderid");
        int oid = Integer.parseInt(orderidString);
        String status = request.getParameter("status");
        int sta = Integer.parseInt(status);
        Order order = new Order();
        order.setOrderid(oid);
        order.setStatus(sta);
        DAOOrder dao = new DAOOrder();
        dao.updateOrder(order);
        response.sendRedirect("managerOrder");
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
