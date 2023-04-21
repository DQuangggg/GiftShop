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
public class managerController extends HttpServlet {

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
            out.println("<title>Servlet managerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managerController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Product> products = new ArrayList<>();
        DAOProduct pd = new DAOProduct();
     
        int count = pd.getTotalProduct();
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        int endPage = count / 15;
        if (count % 15 != 0) {
            endPage++;
        }
        List<Product> list = pd.pagingProduct(index);

        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();
        request.setAttribute("listC", listCategory);
        request.setAttribute("tag", index);
        request.setAttribute("endP", endPage);
        request.setAttribute("listP", list);
        request.getRequestDispatcher("manager.jsp").forward(request, response);
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
        String pidString = request.getParameter("pid");
        int pid = Integer.parseInt(pidString);
        DAOProduct pd = new DAOProduct();
        Product p = new Product();
        p = pd.getProductById(pid);
        ArrayList<Category> listCategory = new ArrayList<>();
        DAOCategory cd = new DAOCategory();
        listCategory = cd.getCategory();
        //if found product
        if (p != null) {
            ArrayList<Product> products = new ArrayList<>();
            products.add(p);
            request.setAttribute("searchMessage", pid);
            request.setAttribute("listP", products);
            request.setAttribute("listC", listCategory);
            request.getRequestDispatcher("manager.jsp").forward(request, response);
        } else {
            request.setAttribute("searchMessage", "No products found");
            request.setAttribute("listC", listCategory);
            request.getRequestDispatcher("manager.jsp").forward(request, response);
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
