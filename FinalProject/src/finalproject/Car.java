/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author adilhassan
 */
public class Car {
    private String carID = new String(); 
    private String manufac = new String(); 
    private String trim = new String(); 
    private int year; 
    private double price; 
    private int quantity; 

    public Car (String carID) { 
        this.carID = carID;
    }
    public String getId(){
        return this.carID;
    }
public void setManu(String manufac){
        this.manufac = manufac;
    }
    public String getManu(){
        return manufac;
    }
    public void setTrim(String trim){
        this.trim = trim;
    }
    public String getTrim(){
        return trim;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getYear(){
        return year;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public void setquan(int quantity){
        this.quantity=quantity;
    }
    public int getquan(){
        return quantity;
    }
}
