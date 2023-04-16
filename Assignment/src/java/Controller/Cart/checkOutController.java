/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Cart;

import DAO.DAOCart;
import DAO.DAOCategory;
import DAO.DAOCustomer;
import DAO.DAOOrder;
import Entity.Cart;
import Entity.Category;
import Entity.Customer;
import Entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class checkOutController extends HttpServlet {

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
        HttpSession session = request.getSession();
        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();

        if (session.getAttribute("listcart") == null) {
            response.sendRedirect("showCartController");
        } else {
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
            double discount = 0;
            double total = 0;
            for (Cart cart : listCart) {
                total = total + cart.getAmount() * cart.getProduct().getProductPrice();
            }
            //if user login
            if (session.getAttribute("acc") != null) {
                discount = Math.floor(total * 0.1);
                double subtotal = total - discount;
                request.setAttribute("discount", discount + "$");
                request.setAttribute("subtotal", subtotal + "$");
                request.setAttribute("listB", listCart);
                request.setAttribute("listC", listCategory);
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            } else {
                request.setAttribute("subtotal", total + "$");
                request.setAttribute("listB", listCart);
                request.setAttribute("listC", listCategory);
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            }
        }
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
        HttpSession session = request.getSession();
        String firstname = request.getParameter("checkoutFName");
        String lastname = request.getParameter("checkoutFName");
        String address = request.getParameter("checkoutAddress");
        String city = request.getParameter("checkoutCity");
        String phone = request.getParameter("checkoutPhone");
        Customer cust = new Customer();
        cust.setFirstname(firstname);
        cust.setLastname(lastname);
        cust.setAddress(address);
        cust.setCity(city);
        cust.setPhone(phone);

        DAOCustomer custdao = new DAOCustomer();
        Customer custcheck = custdao.getCustomer(cust);
        Date today = new Date(System.currentTimeMillis());

        //check new customer has been saved in database before or not
        if (custcheck == null) {
            custdao.insertCustomer(cust);

            int lastCustId = custdao.getLastIdOfCustomer();
            Order order = new Order();
            DAOOrder oda = new DAOOrder();
            order.setCustid(lastCustId);
            order.setOrderDate(today);
            oda.insertOrder(order);
        } else {
            Order order = new Order();
            DAOOrder oda = new DAOOrder();
            order.setCustid(custcheck.getCustid());
            order.setOrderDate(today);
            oda.insertOrder(order);
        }
        // add data to cart table
        ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
        DAOCart cartDAO = new DAOCart();
        for (Cart cart : listCart) {
            cartDAO.insertCart(cart);
        }
        session.removeAttribute("listcart");
        response.sendRedirect("homePageController");
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
