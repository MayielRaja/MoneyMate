package com.example.moneymate;

public class Expense {
    private String title;
    private String category;
    private double amount;
    private String date;
    public Expense(String title,String category,double amount,String date){
        this.title=title;
        this.category=category;
        this.amount=amount;
        this.date=date;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDate(){
        return date;
    }
    public double getAmount(){
        return amount;
    }
}
