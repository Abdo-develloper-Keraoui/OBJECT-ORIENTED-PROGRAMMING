package LibraryCatalog.model;


public class Book extends LibraryItem implements Borrowable, Searchable {

    private String author;
    private String isbn;
    private int pages;

    public Book(String title, int year, String author, String isbn, int pages) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public boolean borrow() {
        if (!isAvailable()) {
            return false;
        }
        setAvailable(false);
        return true;
    }

    @Override
    public boolean returnItem() {
        if (isAvailable()) {
            return false;
        }
        setAvailable(true);
        return true;
    }

    @Override
    public boolean matchesQuery(String query) {
        String lower = query.toLowerCase();
        return getTitle().toLowerCase().contains(lower)
                || author.toLowerCase().contains(lower)
                || isbn.toLowerCase().contains(lower);
    }

    @Override
    public String toString() {
        return "[Book] " + super.toString() + " by " + author
                + " | ISBN: " + isbn + " | " + pages + "p"
                + (isAvailable() ? "" : " [BORROWED]");
    }
}
