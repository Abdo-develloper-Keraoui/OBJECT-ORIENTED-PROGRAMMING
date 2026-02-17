
package LibraryCatalog.ui;

import LibraryCatalog.model.*;
import LibraryCatalog.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final LibraryService service;
    private final Scanner scanner;

    public ConsoleUI(LibraryService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": handleAdd(); break;
                case "2": handleRemove(); break;
                case "3": handleSearch(); break;
                case "4": handleListAvailable(); break;
                case "5": handleListBorrowed(); break;
                case "6": handleBorrow(); break;
                case "7": handleReturn(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid option.");
            }
            System.out.println();
        }
        System.out.println("Goodbye.");
    }

    private void printMenu() {
        System.out.println("=== Library Catalog ===");
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. Search");
        System.out.println("4. List available");
        System.out.println("5. List borrowed");
        System.out.println("6. Borrow item");
        System.out.println("7. Return item");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    private void handleAdd() {
        System.out.println("Type? (book / dvd / magazine)");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine().trim());

        switch (type) {
            case "book":
                System.out.print("Author: ");
                String author = scanner.nextLine().trim();
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine().trim();
                System.out.print("Pages: ");
                int pages = Integer.parseInt(scanner.nextLine().trim());
                service.addItem(new Book(title, year, author, isbn, pages));
                break;
            case "dvd":
                System.out.print("Director: ");
                String director = scanner.nextLine().trim();
                System.out.print("Duration (min): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                service.addItem(new DVD(title, year, director, duration));
                break;
            case "magazine":
                System.out.print("Issue: ");
                String issue = scanner.nextLine().trim();
                System.out.print("Month: ");
                String month = scanner.nextLine().trim();
                service.addItem(new Magazine(title, year, issue, month));
                break;
            default:
                System.out.println("Unknown type.");
                return;
        }
        System.out.println("Item added.");
    }

    private void handleRemove() {
        System.out.print("Title to remove: ");
        String title = scanner.nextLine().trim();
        if (service.removeItem(title)) {
            System.out.println("Removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private void handleSearch() {
        System.out.print("Search query: ");
        String query = scanner.nextLine().trim();
        List<LibraryItem> results = service.searchItems(query);
        if (results.isEmpty()) {
            System.out.println("No results.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void handleListAvailable() {
        List<LibraryItem> items = service.listAvailable();
        if (items.isEmpty()) {
            System.out.println("No available items.");
        } else {
            items.forEach(System.out::println);
        }
    }

    private void handleListBorrowed() {
        List<LibraryItem> items = service.listBorrowed();
        if (items.isEmpty()) {
            System.out.println("No borrowed items.");
        } else {
            items.forEach(System.out::println);
        }
    }

    private void handleBorrow() {
        System.out.print("Title to borrow: ");
        String title = scanner.nextLine().trim();
        try {
            boolean success = service.borrowItem(title);
            if (success) {
                System.out.println("Borrowed successfully.");
            } else {
                System.out.println("Item is already borrowed.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleReturn() {
        System.out.print("Title to return: ");
        String title = scanner.nextLine().trim();
        try {
            boolean success = service.returnItem(title);
            if (success) {
                System.out.println("Returned successfully.");
            } else {
                System.out.println("Item was not borrowed.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}