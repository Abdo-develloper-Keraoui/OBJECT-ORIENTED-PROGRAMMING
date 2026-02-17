package LibraryCatalog;

import LibraryCatalog.model.*;
import LibraryCatalog.repository.LibraryRepository;
import LibraryCatalog.service.LibraryService;
import LibraryCatalog.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        LibraryRepository repository = new LibraryRepository();
        LibraryService service = new LibraryService(repository);

        seedData(service);

        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }

    private static void seedData(LibraryService service) {
        service.addItem(new Book("Clean Code", 2008, "Robert C. Martin", "978-0132350884", 464));
        service.addItem(new Book("Effective Java", 2018, "Joshua Bloch", "978-0134685991", 412));
        service.addItem(new DVD("The Social Network", 2010, "David Fincher", 120));
        service.addItem(new DVD("Inception", 2010, "Christopher Nolan", 148));
        service.addItem(new Magazine("IEEE Software", 2024, "Vol.41 No.3", "May"));
        service.addItem(new Magazine("ACM Computing Surveys", 2023, "Vol.55 No.9", "September"));
    }
}