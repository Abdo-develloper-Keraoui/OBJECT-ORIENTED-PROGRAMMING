package LibraryCatalog.service;

import LibraryCatalog.repository.LibraryRepository;
import LibraryCatalog.model.*;

import java.util.List;

public class LibraryService {
    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;//dependency injection
    }


    public void addItem(LibraryItem item) {
        repository.add(item);
    }

    public boolean removeItem(String title) {
        LibraryItem item = repository.findByTitle(title);
        if (item == null) {
            return false;
        }
        return repository.remove(item);
    }

    public List<LibraryItem> searchItems(String query) {
        return repository.search(query);
    }

    public List<LibraryItem> listAvailable() {
        return repository.findAvailable();
    }

    public List<LibraryItem> listBorrowed() {
        return repository.findBorrowed();
    }

    public boolean borrowItem(String title) {
        LibraryItem item = repository.findByTitle(title);

        if(item == null) {
            throw new IllegalArgumentException("Item doesn't exist: " + title);
        }
        if(!(item instanceof Borrowable)) {
            throw new UnsupportedOperationException("Item isn't borrowable: " + title);
        }
        Borrowable borrowable = (Borrowable) item;
        return borrowable.borrow();
    }

    public boolean returnItem(String title) {
        LibraryItem item = repository.findByTitle(title);

        if(item == null) {
            throw new IllegalArgumentException("Item doesn't exist: " + title);
        }
        if(!(item instanceof Borrowable)) {
            throw new UnsupportedOperationException("Item isn't returnable: " + title);
        }
        Borrowable borrowable = (Borrowable) item;
        return borrowable.returnItem();
    }

}