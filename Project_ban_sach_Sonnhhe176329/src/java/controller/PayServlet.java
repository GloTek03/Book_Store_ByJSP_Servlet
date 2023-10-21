/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dal.ProductDAL;


public class PayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        ProductDAL pDAL = new ProductDAL();
        List<Product> listPay = new ArrayList<>();
        listPay = (List<Product>) session.getAttribute("listCart");
        pDAL.removeAllCart((String) session.getAttribute("user"));
        session.setAttribute("listCart", null);
        for (Product p : listPay) {
            pDAL.addToBill((String) session.getAttribute("user"), p.getPid(), p.getQuantity(), p.getTotal());
            
            int max = pDAL.getProductById(p.getPid()).getQuantity();
            pDAL.DecreaseProduct(p, max);
        }
        response.sendRedirect("history");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

    }

}
