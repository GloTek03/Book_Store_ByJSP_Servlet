/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dal.CategoriesDAL;
import dal.ProductDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categories;
import model.Product;

/**
 *
 * @author BayMaxx
 */
public class adminEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product p = new Product();
        p = new ProductDAL().getProductById(pid);
        List<Categories> listCategories = new ArrayList<Categories>(); 
        CategoriesDAL dal = new CategoriesDAL();
        
        listCategories = dal.getAllCategories();
        request.setAttribute("listCategories", listCategories);
        request.setAttribute("product", p);
        request.getRequestDispatcher("editProductAdmin.jsp").forward(request, response);
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
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String categories = request.getParameter("catid"); 
        String images = request.getParameter("images");
        System.out.println("pid:" + pid);
        System.out.println("name:" + name);
        System.out.println("description:" + description);
        System.out.println("price:" + price);
        System.out.println("quantity:" + quantity);
        System.out.println("categories: " + categories);
        System.out.println("images" + images);
        Product p = new Product(pid, name, description, price, quantity, categories, images);
        ProductDAL dal = new ProductDAL();
        dal.updateProductById(p);
        response.sendRedirect("adminlist");
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
