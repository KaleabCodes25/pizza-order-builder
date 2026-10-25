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

        scanner.close();                             // done reading: release the keyboard

    }

}
