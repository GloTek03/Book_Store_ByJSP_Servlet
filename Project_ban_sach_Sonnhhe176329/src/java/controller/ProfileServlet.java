/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dal.AccountDAL;


public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        request.getRequestDispatcher("profile.jsp").include(request, response);
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String newpass = request.getParameter("newpass");
        
        AccountDAL aDAL = new AccountDAL();
        boolean checkUpdate = aDAL.updateAccount(username, email, phone, address, newpass);
        if(checkUpdate){
            session.setAttribute("pass", newpass);
            response.sendRedirect("profile");
        }
        
        
    }

}
