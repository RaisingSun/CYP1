package db;
// Generated 2013-9-19 19:58:32 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Dishes generated by hbm2java
 */
public class Dishes  implements java.io.Serializable {


     private Integer id;
     private Window window;
     private String dno;
     private String dname;
     private double price;
     private Integer typeNo;
     private Set<Peopleaction> peopleactions = new HashSet<Peopleaction>(0);
     private String taste;

    public Dishes() {
    }

	
    public Dishes(Window window, String dno, String dname, double price) {
        this.window = window;
        this.dno = dno;
        this.dname = dname;
        this.price = price;
    }
    public Dishes(Window window, String dno, String dname, double price, Integer typeNo, Set<Peopleaction> peopleactions) {
       this.window = window;
       this.dno = dno;
       this.dname = dname;
       this.price = price;
       this.typeNo = typeNo;
       this.peopleactions = peopleactions;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Window getWindow() {
        return this.window;
    }
    
    public void setWindow(Window window) {
        this.window = window;
    }
    public String getDno() {
        return this.dno;
    }
    
    public void setDno(String dno) {
        this.dno = dno;
    }
    public String getDname() {
        return this.dname;
    }
    
    public void setDname(String dname) {
        this.dname = dname;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public Integer getTypeNo() {
        return this.typeNo;
    }
    
    public void setTypeNo(Integer typeNo) {
        this.typeNo = typeNo;
    }
    public Set<Peopleaction> getPeopleactions() {
        return this.peopleactions;
    }
    
    public void setPeopleactions(Set<Peopleaction> peopleactions) {
        this.peopleactions = peopleactions;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
    public String getTaste() {
        return this.taste;
    }


}


