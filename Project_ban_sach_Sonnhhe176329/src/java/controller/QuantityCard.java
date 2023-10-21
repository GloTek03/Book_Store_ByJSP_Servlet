/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author BayMaxx
 */
public class QuantityCard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("pid"); 
        HashMap<String, Integer> hashCart = new HashMap<String, Integer>();
        ProductDAL pDAL = new ProductDAL();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        if (username != null) {
            hashCart = pDAL.getCart(username);
        }
        if (hashCart.containsKey(pid)) {
            hashCart.put(pid, (hashCart.get(pid) -1 ));
            pDAL.updateCart(username, pid, hashCart.get(pid));
            session.setAttribute("hashCart", hashCart);
        }
        response.sendRedirect("cart");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("pid"); 
        HashMap<String, Integer> hashCart = new HashMap<String, Integer>();
        ProductDAL pDAL = new ProductDAL();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        if (username != null) {
            hashCart = pDAL.getCart(username);
        }
        if (hashCart.containsKey(pid)) {
            hashCart.put(pid, (hashCart.get(pid) + 1 ));
            pDAL.updateCart(username, pid, hashCart.get(pid));
            session.setAttribute("hashCart", hashCart);
        }
        response.sendRedirect("cart");
    }

}
