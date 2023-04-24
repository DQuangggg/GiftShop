/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Cart;

import DAO.DAOCart;
import DAO.DAOOrder;
import DAO.DAOProduct;
import Entity.Cart;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class cartController extends HttpServlet {

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
         processRequest(request, response);
//        HttpSession session = request.getSession();
//
//        String pidString = request.getParameter("pid");
//        int pid = Integer.parseInt(pidString);
//        DAOProduct pd = new DAOProduct();
//        Product p = pd.getProductById(pid);
//        int amount = 1;
//
//        DAOCart cartDAO = new DAOCart();
//        DAOOrder od = new DAOOrder();
//        int cartId = od.getLastIdOfOrder() + 1;
//
//        Cart c = new Cart();
//        c.setCartid(cartId);
//        c.setAmount(amount);
//        c.setProduct(p);
//
//        // check listcart on session null or not 
//        if (session.getAttribute("listcart") != null) {
//            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
//            boolean sameProduct = false;
//            for (Cart cart : listCart) {
//                //check new product exist in listcart or not
//                if (cart.getProduct().getPid() == pid) {
//                    cart.setAmount(cart.getAmount() + 1);
//                    sameProduct = true;
//                }
//            }
//            if (!sameProduct) {
//                listCart.add(c);
//            }
//            session.setAttribute("listcart", listCart);
//            session.setAttribute("number", listCart.size());
//            response.sendRedirect("showCartController");
//        } else {
//            ArrayList<Cart> listCart = new ArrayList<>();
//            listCart.add(c);
//            session.setAttribute("listcart", listCart);
//            session.setAttribute("number", listCart.size());
//            response.sendRedirect("showCartController");
//
//        }
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
        String pidString = request.getParameter("pid");
        int pid = Integer.parseInt(pidString);
        DAOProduct pd = new DAOProduct();
        Product p = pd.getProductById(pid);
        String amountString = request.getParameter("quantity");
        int amount = Integer.parseInt(amountString);
        DAOCart cartDAO = new DAOCart();
        DAOOrder od = new DAOOrder();
        int cartId = od.getLastIdOfOrder() + 1;
        Cart c = new Cart();

        c.setCartid(cartId);
        c.setAmount(amount);
        c.setProduct(p);

        // check listcart on session null or not 
        if (session.getAttribute("listcart") != null) {
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");
            boolean sameProduct = false;
            for (Cart cart : listCart) {
                //check new product exist in listcart or not
                if (cart.getProduct().getPid() == pid) {
                    cart.setAmount(cart.getAmount() + amount);
                    sameProduct = true;
                }
            }
            //if not the same product add new product to list
            if (!sameProduct) {
                listCart.add(c);
            }
            session.setAttribute("listcart", listCart);
            session.setAttribute("number", listCart.size());
            response.sendRedirect("showCartController");
        } else {
            ArrayList<Cart> listCart = new ArrayList<>();
            listCart.add(c);
            session.setAttribute("listcart", listCart);
            session.setAttribute("number", listCart.size());

            response.sendRedirect("showCartController");

        }
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
