package com.anapiqueras;

public class Book {
     private String name;
     private double price;
 
     public Book(String name, double price) throws NullNameException{
         setName(name);
         setPrice(price);
     }

    public void setName(String name) throws NullNameException{
        if(name==null){
            throw new NullNameException("Name can't be null");
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public String toString(){
        return "name:"+this.name+" price:"+price;
    }
 
     
}
