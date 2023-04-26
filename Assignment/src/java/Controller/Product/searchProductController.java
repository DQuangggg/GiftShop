/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Product;

import DAO.DAOCategory;
import DAO.DAOProduct;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class searchProductController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String nameSearch = request.getParameter("q");
        DAOProduct pd = new DAOProduct();

        int count = pd.getTotalProductBySearch(nameSearch);
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        int endPage = count / 15;
        if (count % 15 != 0) {
            endPage++;
        }
        List<Product> products = new ArrayList<>();
        products = pd.pagingProdctBySearch(nameSearch, index);

        if (products.isEmpty() == false) {
            boolean issearch = true;
            ArrayList<Category> listCategory = new ArrayList<>();
            DAOCategory cd = new DAOCategory();
            listCategory = cd.getCategory();
            request.setAttribute("listC", listCategory);
            request.setAttribute("listP", products);

            request.setAttribute("issearch", issearch);
            request.setAttribute("textsearch", nameSearch);
            request.setAttribute("tag", index);
            request.setAttribute("endP", endPage);

            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            ArrayList<Category> listCategory = new ArrayList<>();
            DAOCategory cd = new DAOCategory();
            listCategory = cd.getCategory();
            boolean issearch = true;
            request.setAttribute("issearch", issearch);

            request.setAttribute("listC", listCategory);
            request.setAttribute("textsearch", "Don't find any product have name contain " + nameSearch);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        String nameSearch = request.getParameter("q");
        DAOProduct pd = new DAOProduct();

        int count = pd.getTotalProductBySearch(nameSearch);
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        int endPage = count / 15;
        if (count % 15 != 0) {
            endPage++;
        }
        List<Product> products = new ArrayList<>();
        products = pd.pagingProdctBySearch(nameSearch, index);

        if (products.isEmpty() == false) {
            boolean issearch = true;
            ArrayList<Category> listCategory = new ArrayList<>();
            DAOCategory cd = new DAOCategory();
            listCategory = cd.getCategory();
            request.setAttribute("listC", listCategory);
            request.setAttribute("listP", products);

            request.setAttribute("issearch", issearch);
            request.setAttribute("textsearch", nameSearch);
            request.setAttribute("tag", index);
            request.setAttribute("endP", endPage);

            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            ArrayList<Category> listCategory = new ArrayList<>();
            DAOCategory cd = new DAOCategory();
            listCategory = cd.getCategory();
            boolean issearch = true;
            request.setAttribute("issearch", issearch);

            request.setAttribute("listC", listCategory);
            request.setAttribute("textsearch", "Don't find any product have name contain " + nameSearch);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
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
