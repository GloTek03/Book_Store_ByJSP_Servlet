
package model;

import java.util.Date;

public class Bill {

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private String bid;
    private String username;
    private String pid;
    private Date date;
    private int amount;
    private float total;
    private String name;
    private String desc;
    private float price;
    private String catid;
    private String image;

    public Bill() {
    }
    
    public Bill(String bid, String username, String pid, Date date, int amount, float total, String name, String desc, float price, String catid, String image) {
        this.bid = bid;
        this.username = username;
        this.pid = pid;
        this.date = date;
        this.amount = amount;
        this.total = total;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.catid = catid;
        this.image = image;
    }
    
    
}
