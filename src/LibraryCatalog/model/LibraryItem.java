package LibraryCatalog.model;


public abstract class LibraryItem {

    private String title;
    private int year;
    private boolean available;

    public LibraryItem(String title, int year) {
        this.title = title;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    protected void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}