package com.engimacamp;

import com.engimacamp.models.Product;
import com.engimacamp.models.enums.Category;
import com.engimacamp.services.InventoryService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static InventoryService inventoryService;
    private static Scanner scanner;

    public static void main(String[] args) {
        initialize();
        showMenu();
    }


    public static void initialize(){
        scanner = new Scanner(System.in);
        inventoryService = new InventoryService();

    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n=== POS System Menu ===");
            System.out.println("1. Transaction Management");
            System.out.println("2. Inventory Management");
            System.out.println("3. Report Generation");
            System.out.println("4. System Management");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    transactionManagement();
                    break;
                case 2:
                    inventoryManagement();
                    break;
                case 3:
                    // Report Generation
                    break;
                case 4:
                    // System Management
                    break;
                case 5:
                    // Exit
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void transactionManagement() {
        System.out.println("\n=== Transaction Management ===");

        while (true) {
            System.out.println("1. New Transaction");
            System.out.println("2. Back");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    newTransaction();
                    break;
                case 2:
                    // Back
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void newTransaction() {
        System.out.println("\n=== New Transaction ===");

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Complete Transaction");
            System.out.println("3. Back");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
           scanner.nextLine();
           if (choice == 1) {
               System.out.print("Enter Product ID: ");
               String productId = scanner.nextLine();
               System.out.print("Enter Quantity: ");
               int quantity = scanner.nextInt();

           }
        }
    }

    private static void inventoryManagement() {

        while (true) {
            System.out.println("\n=== Inventory Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Check Stock Level");
            System.out.println("4. Back");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                String productId = scanner.nextLine();
                System.out.print("Enter Product Name: ");
                String name = scanner.nextLine();
                System.out.println("Select Category:");
                for (int i = 0; i < Category.values().length; i++) {
                    System.out.println((i + 1) + ". " + Category.values()[i]);
                }
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();
                Category category = Category.values()[categoryChoice - 1];
                System.out.print("Enter Buy Price: ");
                BigDecimal buyPrice = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.print("Enter Sell Price: ");
                BigDecimal sellPrice = scanner.nextBigDecimal();
                scanner.nextLine();
                System.out.print("Enter Stock: ");
                int stock = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Minimum Stock: ");
                int minStock = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                String expiryDateString = scanner.nextLine();
                LocalDate expiryDate = LocalDate.parse(expiryDateString);
                Product product = new Product(productId, name, category , buyPrice, sellPrice, stock, minStock, expiryDate);
                inventoryService.addProduct(product);
                System.out.println("Product added successfully.");
                System.out.println(inventoryService.getProducts());
            } else if (choice == 2) {
                System.out.println("Enter Product ID: ");
                String productId = scanner.nextLine();
                System.out.println("Enter Stock: ");
                int stock = scanner.nextInt();
                scanner.nextLine();
                inventoryService.updateStock(productId, stock);
                System.out.println("Stock updated successfully.");
                System.out.println(inventoryService.getProducts());
            } else if (choice == 3) {
                System.out.println("Enter Category to check stock level:");
                // Tampilkan daftar kategori untuk memilih
                for (int i = 0; i < Category.values().length; i++) {
                    System.out.println((i + 1) + ". " + Category.values()[i]);
                }
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();
                Category selectedCategory = Category.values()[categoryChoice - 1];

                // Panggil checkLevelStock untuk kategori yang dipilih
                inventoryService.checkLevelStock(selectedCategory);
            }
            else if (choice == 4) {
                // Back
                return;
            }else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}

