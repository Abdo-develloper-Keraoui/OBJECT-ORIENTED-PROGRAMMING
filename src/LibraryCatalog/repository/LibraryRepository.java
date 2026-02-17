package LibraryCatalog.repository;

import LibraryCatalog.model.LibraryItem;
import LibraryCatalog.model.Searchable;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    private final List<LibraryItem> items = new ArrayList<>();

    public void add(LibraryItem item) {
        items.add(item);
    }

    public boolean remove(LibraryItem item) {
        return items.remove(item);
    }

    public List<LibraryItem> findAll() {
        return new ArrayList<>(items);
    }

    public List<LibraryItem> findAvailable() {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> findBorrowed() {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (!item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> search(String query) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Searchable) {
                Searchable searchable = (Searchable) item;
                if (searchable.matchesQuery(query)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    public LibraryItem findByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public int count() {
        return items.size();
    }
}