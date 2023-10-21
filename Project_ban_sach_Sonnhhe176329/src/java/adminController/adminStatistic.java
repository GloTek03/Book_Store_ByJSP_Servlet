/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminController;

import dal.AccountDAL;
import dal.BillDAL;
import dal.ProductDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Bill;
import model.Product;


/**
 *
 * @author BayMaxx
 */
public class adminStatistic extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Bill> lsBill = new ArrayList<Bill>();
        BillDAL billdal = new BillDAL();
        ProductDAL pDAL = new ProductDAL();
        AccountDAL aDAL = new AccountDAL();
        
        List<Product> lsProduct = new ArrayList<Product>(); 
        List<Account> lsAccount = new ArrayList<Account>(); 
        lsBill = billdal.getTop3BestSeller();
        for (Bill bill : lsBill) {
            String pid = bill.getPid(); 
            Product p = new Product();
            p = pDAL.getProductById(pid);
            lsProduct.add(p);
        }
        lsBill = billdal.getTop10Username();
        System.out.println(lsBill.size());
        for (Bill bill : lsBill) {
            String username = bill.getUsername(); 
            Account acc = new Account();
            acc = aDAL.getAccountByUsername(username);
            lsAccount.add(acc);
        }
        System.out.println("lsAccount.size()" + lsAccount.get(0).getUsername());
        request.setAttribute("top5Product", lsProduct);
        request.setAttribute("top10User", lsAccount);
        request.getRequestDispatcher("statisticAdmin.jsp").forward(request, response);
    }
    
}
