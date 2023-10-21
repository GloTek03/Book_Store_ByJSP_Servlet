
package dal;

import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAL extends DBContext{
    public Account getAccountByUsername(String username){
        String  xSql = "select * from Accounts where username=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getInt("role"));
                ps.close();
                rs.close();
                return a;
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Account checkAccount(String user, String pass) {
        
        String xSql = "select * from Accounts where username=? AND password=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getInt("role"));
                ps.close();
                rs.close();
                return a;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean addAccount(String username, String password, String fullname, String email, String phone, String address) {
        String xSql = "insert into Accounts(username, password, fullname, email, phone, address, role) values (?, ?, ?, ?, ?, ?, 2)";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateAccount(String username, String email, String phone, String address, String newpass) {
        String xSql = "update Accounts set password=?, email=?, phone=?, [address]=? where username=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, newpass);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, username);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        AccountDAL dao = new AccountDAL();
        System.out.println(dao.checkAccount("admin", "123"));
        
    }

    public int getRoleByUser(String username, String password ) {
        String xSql = "select role from Accounts where username=? AND password=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int a = rs.getInt("role"); 
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2;
    }
}
