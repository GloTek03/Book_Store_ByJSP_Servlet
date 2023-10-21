
package model;

public class Categories {
    String catid; 
    String name; 

    public Categories() {
    }

    public Categories(String catid, String name) {
        this.catid = catid;
        this.name = name;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
