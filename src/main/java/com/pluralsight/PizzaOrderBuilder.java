package com.pluralsight;

import java.util.Scanner;

public class PizzaOrderBuilder {
    public static void main(String[] args) {

        // One Scanner reads everything the user types
        Scanner scanner = new Scanner(System.in);

        // The customer name, cleaned up
        System.out.print("What is your name? ");
        String nameInput = scanner.nextLine();
        String customerName = nameInput.trim().toUpperCase();
        System.out.println("Hello, " + customerName + "!");

        // Read the count as text, then turn the text into a number
        System.out.print("How many pizzas? ");
        String countText = scanner.nextLine();
        int pizzaCount = Integer.parseInt(countText.trim());

        // One slot per pizza, filled one at a time
        Pizza[] pizzas = new Pizza[pizzaCount];
        for (int i = 0; i < pizzas.length; i++) {
            System.out.println("Pizza " + (i + 1) + ":");
            pizzas[i] = askPizza(scanner);
        }

        // The receipt: one line per pizza, read back through the getters
        System.out.println();
        System.out.println("Receipt for " + customerName);
        for (int i = 0; i < pizzas.length; i++) {
            Pizza pizza = pizzas[i];
            System.out.printf("Pizza %d: %s, %s, $%.2f%n", i + 1, pizza.getSize(), pizza.getToppings(), pizza.getPrice());
        }

        // Add up the prices: for-each visits every pizza in the array
        double total = 0.00;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        System.out.printf("Total: $%.2f%n", total);


        System.out.println("Kitchen ticket: " + buildTicket(customerName, pizzas));
    }
    // Returns the price of one pizza of the given size
    public static double getSizePrice(String size) {
        double price;
        switch (size) {
            case "small" -> price = 9.00;
            case "medium" -> price = 11.50;
            case "large" -> price = 14.00;
            default -> price = 0.00;
        }
        return price;
    }

    // Asks for the size and toppings of one pizza, and returns it
    public static Pizza askPizza(Scanner scanner) {
// The size, in lower case so the switch can match it
        System.out.print("Size (small/medium/large)? ");
        String size = scanner.nextLine().trim().toLowerCase();
        double price = getSizePrice(size);

        // The toppings, split at each comma
        System.out.print("Toppings (separated by commas, or none)? ");
        String toppingsLine = scanner.nextLine().trim();
        if (toppingsLine.equalsIgnoreCase("none")) {
            return new Pizza(size, price);               // the size-only constructor
        }
        Pizza pizza = new Pizza(size, toppingsLine, price);
        String[] toppings = toppingsLine.split(",");
        pizza.setPrice(pizza.getPrice() + toppings.length * 1.25);   // 1.25 per topping

        return pizza;
    }

    // Builds the kitchen ticket, for example NADIA-L-M
    public static String buildTicket(String customerName, Pizza[] pizzas) {
        StringBuilder ticket = new StringBuilder();
        for (Pizza pizza : pizzas) {
            ticket.append("-");
            ticket.append(pizza.getSize().charAt(0));
        }
        ticket.insert(0, customerName);
        return ticket.toString().toUpperCase();
    }

}
