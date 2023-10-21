package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Bill;

public class BillDAL extends DBContext{
    public List<Bill> getTop3BestSeller(){
         String xSql = "select top 3 pid,sum(b.amount) countAmount\n"
                + "from Bills b\n"
                + "group by pid\n"
                + "order by countAmount desc ";
        List<Bill> lsBill = new ArrayList<Bill>();
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setPid(rs.getString("pid"));
                bill.setAmount(rs.getInt("countAmount"));
                lsBill.add(bill);
            }
           return lsBill;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
    
    public List<Bill> getTop10Username(){
        String xSql = "select top 10 username, sum(b.total) total\n"
                + "from Bills b \n"
                + "group by username\n"
                + "order by total desc";
        List<Bill> lsBill = new ArrayList<Bill>();
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setUsername(rs.getString("username"));
                bill.setTotal(rs.getFloat("total"));
                lsBill.add(bill);
            }
           return lsBill;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
    public static void main(String[] args) {
        BillDAL dal = new BillDAL(); 
        System.out.println(dal.getTop10Username().get(0).getTotal());
    }
}
