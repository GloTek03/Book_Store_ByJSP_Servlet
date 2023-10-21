/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import dal.CategoriesDAL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categories;

/**
 *
 * @author BayMaxx
 */
public class adminAddCategories extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addCategoryAdmin.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("catid");
        String name = request.getParameter("name");
        System.out.println("catid:" + id);
        System.out.println("name" + name);
        Categories cat = new Categories(id, name);
        CategoriesDAL dal = new CategoriesDAL();
        dal.addNewCategory(cat);
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
