package com.example.Ecosmartsystem;

public class DTOtransaction {
    private int id;
    private int amount;
    private int date;
    private int categoryid;
    private String categoryname;

    public DTOtransaction(int id, int amount, int date, int categoryid, String categoryname) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }
    public DTOtransaction() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
