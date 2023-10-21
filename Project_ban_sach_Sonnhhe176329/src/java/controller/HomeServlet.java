/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAL;
import model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dal.ProductDAL;

public class HomeServlet extends HttpServlet {

    HashMap<String, Integer> hashCart = new HashMap<String, Integer>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        AccountDAL aDAL = new AccountDAL();
        ProductDAL pDAL = new ProductDAL();
        HttpSession session = request.getSession();
        //////////////////////////////////////////
        String username = (String) session.getAttribute("user");
        String password = (String) session.getAttribute("pass");
        if ( aDAL.getRoleByUser(username,password) == 1 ) {
            request.getRequestDispatcher("adminlist").include(request, response);
            return; 
        }
        
        String category = request.getParameter("catid");
        String search = (String) request.getParameter("search");
        String sort = (String) request.getParameter("sort");
        List<Product> bookList = new ArrayList<>();
        //////////////////////////////////////////
        if (category == null || category.equals("")) {
            bookList = pDAL.getAllProduct();
            if (search == null || search.equals("")) {
                bookList = pDAL.getAllProduct();
            } else {
                bookList = pDAL.getProductBySerch(search);
            }
        } else {
            bookList = pDAL.getProductByCategory(category);
        }

        if (category == null || category.equals("")) {
            bookList = pDAL.getAllProduct();
            if (sort == null || sort.equals("")) {
                bookList = pDAL.getAllProduct();
            } else {
                if (sort.equals("price"))
                    bookList = pDAL.getProductOrderByPrice(search);
                if (sort.equals("bestSeller"))
                    bookList = pDAL.getProductOrderByBestSeller(search);
                 if (sort.equals("name"))
                    bookList = pDAL.getProductOrderByName(search);
            }
        } else {
            bookList = pDAL.getProductByCategory(category);
        }
        int page, numperpage=6;
        int size=bookList.size();
        int num=(size%6==0?(size/6):((size/6))+1);//so trang
        String xpage=request.getParameter("page");
        if(xpage==null){
            page=1;
        }else{
            page=Integer.parseInt(xpage);
        }
        int start,end;
        start=(page-1)*numperpage;
        end=Math.min(page*numperpage, size);
        List<Product> list=pDAL.getListByPage(bookList, start, end);

        //request.setAttribute("data", list);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        
        
        request.setAttribute("bookList", list);
        ///////////////////////////////////////////
        try {
            String pid = request.getParameter("pid");
            int amount = Integer.parseInt(request.getParameter("amount"));
            if (pid == null || amount == 0) {
                request.getRequestDispatcher("shop.jsp").include(request, response);
            } else {
                if (username != null) {
                    hashCart = pDAL.getCart(username);
                }
                if (hashCart.containsKey(pid)) {
                    hashCart.put(pid, (hashCart.get(pid) + amount));
                    pDAL.updateCart(username, pid, hashCart.get(pid));
                    session.setAttribute("hashCart", hashCart);
                } else {
                    hashCart.put(pid, amount);
                    pDAL.addToCart(username, pid, hashCart.get(pid));
                    session.setAttribute("hashCart", hashCart);
                }
                request.getRequestDispatcher("shop.jsp").include(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("shop.jsp").include(request, response);
        }

//        request.getRequestDispatcher("shop.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
    }

}
