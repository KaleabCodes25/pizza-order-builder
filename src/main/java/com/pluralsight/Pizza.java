package com.pluralsight;

public class Pizza {
    // Private fields: only code inside Pizza can use them
    private String size;
    private String toppings;
    private double price;

    // The constructor fills the fields when a pizza is created
    public Pizza(String size, String toppings, double price) {
        this.size = size;
        this.toppings = toppings;
        this.price = price;
    }

    // Getters: read a field from outside the class
    public String getSize() {
        return this.size;
    }

    public String getToppings() {
        return this.toppings;
    }

    public double getPrice() {
        return this.price;
    }

    // Setters: change a field from outside the class
    public void setSize(String size) {
        this.size = size;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
