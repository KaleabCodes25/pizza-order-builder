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
}
