package dal;

import model.Account;
import model.Bill;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ProductDAL extends DBContext{

    public List<Product> getAllProduct() {
        
        List<Product> list = new ArrayList<Product>();
        String xSql = "select * from Products";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductByCategory(String category) {
        
        List<Product> list = new ArrayList<Product>();
        String xSql = "select * from Products where catid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Product> getProductBySerch(String search) {
        
        List<Product> list = new ArrayList<Product>();
        String xSql = "select * from Products where name like ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, search + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductById(String pid) {
        String xSql = "select * from Products where pid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                ps.close();
                rs.close();
                return p;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addToCart(String username, String pid, int amount){
        String xSql = "insert into Carts(username, pid, amount) values (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pid);
            ps.setInt(3, amount);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateCart(String username, String pid, int amount){
        String xSql = "update Carts set amount=? where username=? and pid=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setInt(1, amount);
            ps.setString(2, username);
            ps.setString(3, pid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public HashMap<String, Integer> getCart(String username){
        
        HashMap<String, Integer> hashCart = new HashMap<>();
        String xSql = "select * from Carts where username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hashCart.put(rs.getString("pid"), rs.getInt("amount"));
            }
            return hashCart;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashCart;
    }
    
    public void removeProductCart(String username, String pid){
        String xSql = "DELETE FROM Carts WHERE username=? and pid=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pid);
            ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeAllCart(String username){
        String xSql = "DELETE FROM Carts WHERE username=?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addToBill(String username, String pid, int amount, float total){
        String xSql = "insert into Bills(bid, username, pid, date, amount, total) values (?, ?, ?, GETDATE(), ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, username);
            ps.setString(3, pid);
            ps.setInt(4, amount);
            ps.setFloat(5, total);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Bill> getAllBillByUser(String username){
        
        List<Bill> listB = new ArrayList<>();
        String xSql = "select * from Bills b JOIN Products p ON b.pid = p.pid WHERE b.username=?";
        try {
            PreparedStatement ps  = con.prepareStatement(xSql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill b = new Bill(rs.getString("bid"), rs.getString("username"), rs.getString("pid"), rs.getDate("date"), rs.getInt("amount"), rs.getFloat("total"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getString("catid"), rs.getString("image"));
                listB.add(b);
            }
            return listB;
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return null;
    }
    public void addNewProduct(Product p){
        String xSql = "insert into Products(pid, name, description, price, quantity, catid, image) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, p.getPid());
            ps.setString(2, p.getName());
            ps.setString(3, p.getDescription());
            ps.setFloat(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setString(6, p.getCatid());
            ps.setString(7, p.getImage());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        ProductDAL dal = new ProductDAL();
        System.out.println(dal.getAllBillByUser("admin"));
    }

    public void deleteProductByPid(String pid) {
        String xSql = "DELETE FROM Products WHERE pid= ? ";
        System.out.println("deleteProductByPid: " + pid);
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProductById(Product p) {
        String xSql = "UPDATE Products set name = ? ,"
                                        + "description = ? , "
                                        + "price = ? ,"
                                        + "quantity = ? , "
                                        + "catid = ?, "
                                        + "image = ?  "
                                        + "where pid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setFloat(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setString(5, p.getCatid());
            ps.setString(6, p.getImage());
            ps.setString(7, p.getPid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void DecreaseProduct(Product p, int maxQuantity) {
        String xSql = "UPDATE Products set quantity = ? where pid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            System.out.println("maxQuantity - p.getQuantity()" + (maxQuantity - p.getQuantity()));
            ps.setInt(1, maxQuantity - p.getQuantity());
            ps.setString(2,p.getPid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getListByPage(List<Product> list, int start,int end){
        ArrayList<Product> arr=new ArrayList<>();
        for(int i=start;i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Product> getProductOrderByPrice(String search) {
        List<Product> list = new ArrayList<Product>();
        String xSql = "select * from Products\n" +
                        "order by price asc";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductOrderByBestSeller(String search) {
        List<Product> list = new ArrayList<Product>();
        String xSql = "select p.*, isnull(sum(b.amount),0)  countAmount\n"
                + "from Products p left join Bills b on p.pid = b.pid \n"
                + "group by p.pid, p.name, p.description, p.price, p.quantity, p.catid, p.image\n"
                + "order by countAmount desc";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                int quant = rs.getInt("countAmount"); 
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductOrderByName(String search) {
        List<Product> list = new ArrayList<Product>();
        String xSql = "select * from Products\n" +
                        "order by name asc";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("pid"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getInt("quantity"), rs.getString("catid"), rs.getString("image"));
                list.add(p);
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
