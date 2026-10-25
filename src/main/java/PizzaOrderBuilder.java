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
        System.out.println("Pizzas: " + pizzaCount);

        // The toppings, split at each comma
        System.out.print("Toppings (separated by commas)? ");
        String toppingsLine = scanner.nextLine().trim();
        String[] toppings = toppingsLine.split(",");

        // Check the values
        System.out.println("Toppings: " + toppings.length);
        for (int i = 0; i < toppings.length; i++) {
            System.out.println("  " + (i + 1) + ". " + toppings[i].trim());
        }

        scanner.close();                             // done reading: release the keyboard

    }

}
