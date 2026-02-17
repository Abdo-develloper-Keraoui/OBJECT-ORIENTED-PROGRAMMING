package LibraryCatalog.model;

public class DVD extends LibraryItem implements Borrowable, Searchable {

    private String director;
    private int duration;

    public DVD(String title, int year, String director, int duration) {
        super(title, year);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
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
                || director.toLowerCase().contains(lower);
    }

    @Override
    public String toString() {
        return "[DVD] " + super.toString() + " dir. " + director
                + " | " + duration + "min"
                + (isAvailable() ? "" : " [BORROWED]");
    }
}
