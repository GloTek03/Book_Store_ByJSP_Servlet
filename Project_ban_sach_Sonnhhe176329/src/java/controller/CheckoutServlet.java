/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Product;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dal.AccountDAL;
import dal.ProductDAL;


public class CheckoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        List<Product> listCart = new ArrayList<>();
//        AccountDAL aDAL = new AccountDAL();
//        ProductDAL pDAL = new ProductDAL();
//        Account currAcc = aDAL.getAccountByUsername((String) session.getAttribute("user"));
//        request.setAttribute("currAcc", currAcc);
//        
//        listCart = (List<Product>) session.getAttribute("listCart");
        AccountDAL aDAL = new AccountDAL();
        Account currAcc = aDAL.getAccountByUsername((String) session.getAttribute("user"));
        request.setAttribute("currAcc", currAcc);
        List<Product> listTotal = (List<Product>) session.getAttribute("listCart");
        float total = 0;
        for (Product p : listTotal) {
            total += p.getTotal();
        }
        request.setAttribute("total", total);
        request.getRequestDispatcher("checkout.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

    }

}
