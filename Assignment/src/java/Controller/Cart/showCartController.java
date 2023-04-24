/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Cart;

import DAO.DAOCategory;
import DAO.DAOProduct;
import Entity.Cart;
import Entity.Category;
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
public class showCartController extends HttpServlet {

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
        ArrayList<Product> productsBest = new ArrayList<>();
        DAOProduct pd = new DAOProduct();
        productsBest = pd.get8BestSell();
        request.setAttribute("listB", productsBest);

        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();

        int numProducts = 0;

        if (session.getAttribute("listcart") != null) {
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("listcart");

            double discount = 0;
            double total = 0;
            for (Cart cart : listCart) {
                total = total + cart.getAmount() * cart.getProduct().getProductPrice();
                numProducts += cart.getAmount();
                request.setAttribute("numProducts", numProducts);
            }

            //if user login
            if (session.getAttribute("acc") != null) {
                discount = Math.floor(total * 0.1 * 10.0) / 10.0;
                double subtotal = total - discount;
                String discountMess = "Discount 10%";
                String subtotalMess = "Subtotal";
                request.setAttribute("discountMess", discountMess);
                request.setAttribute("subtotalMess", subtotalMess);
                request.setAttribute("discount", discount + "$");
                request.setAttribute("subtotal", subtotal + "$");
                request.setAttribute("listC", listCategory);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            } else {
                String discountMess = "Discount";
                String subtotalMess = "Subtotal";
                request.setAttribute("discountMess", discountMess);
                request.setAttribute("subtotalMess", subtotalMess);
                request.setAttribute("subtotal", total + "$");
                request.setAttribute("listC", listCategory);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
        } else {
            String discountMess = "YOUR CART IS CURRENTLY EMPTY!";
            String subtotalMess = "Click on Continue shopping to shop.";
            request.setAttribute("numProducts", 0);
            request.setAttribute("discountMess", discountMess);
            request.setAttribute("subtotalMess", subtotalMess);
            request.setAttribute("listC", listCategory);;
            request.getRequestDispatcher("cart.jsp").forward(request, response);

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
        processRequest(request, response);
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
