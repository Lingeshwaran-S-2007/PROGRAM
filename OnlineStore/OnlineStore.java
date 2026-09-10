import java.util.Scanner;

// Product class
class Product {
    // Data members
    String name;
    double price;
    int quantity;

    // Constructor
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate total price
    double calculateTotal() {
        return price * quantity;
    }

    // Method to calculate discount
    double calculateDiscount(double discountRate) {
        return calculateTotal() * discountRate / 100;
    }

    // Method to calculate tax
    double calculateTax(double taxRate, double amountAfterDiscount) {
        return amountAfterDiscount * taxRate / 100;
    }

    // Method to calculate final price
    double calculateFinalPrice(double discountRate, double taxRate) {
        double total = calculateTotal();
        double discount = calculateDiscount(discountRate);
        double amountAfterDiscount = total - discount;
        double tax = calculateTax(taxRate, amountAfterDiscount);

        return amountAfterDiscount + tax;
    }

    // Method to display product details
    void displayDetails(double discountRate, double taxRate) {
        double total = calculateTotal();
        double discount = calculateDiscount(discountRate);
        double amountAfterDiscount = total - discount;
        double tax = calculateTax(taxRate, amountAfterDiscount);
        double finalPrice = calculateFinalPrice(discountRate, taxRate);

        System.out.println("\n========== PRODUCT BILL ==========");
        System.out.println("Product Name       : " + name);
        System.out.println("Price per Item     : ₹" + price);
        System.out.println("Quantity           : " + quantity);
        System.out.println("----------------------------------");
        System.out.println("Total Price        : ₹" + total);
        System.out.println("Discount (" + discountRate + "%)   : ₹" + discount);
        System.out.println("After Discount     : ₹" + amountAfterDiscount);
        System.out.println("Tax (" + taxRate + "%)        : ₹" + tax);
        System.out.println("----------------------------------");
        System.out.println("Final Price        : ₹" + finalPrice);
        System.out.println("==================================");
    }
}

// Main class
public class OnlineStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price of product: ₹");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter discount percentage: ");
        double discountRate = scanner.nextDouble();

        System.out.print("Enter tax percentage: ");
        double taxRate = scanner.nextDouble();

        // Creating an object using the constructor
        Product product = new Product(name, price, quantity);

        // Calling the method to display the bill
        product.displayDetails(discountRate, taxRate);

        scanner.close();
    }
}