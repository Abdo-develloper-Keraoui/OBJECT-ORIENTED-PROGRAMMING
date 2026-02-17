package LibraryCatalog.model;


public class Magazine extends LibraryItem implements Searchable {

    private String issue;
    private String month;

    public Magazine(String title, int year, String issue, String month) {
        super(title, year);
        this.issue = issue;
        this.month = month;
    }

    public String getIssue() {
        return issue;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public boolean matchesQuery(String query) {
        String lower = query.toLowerCase();
        return getTitle().toLowerCase().contains(lower)
                || issue.toLowerCase().contains(lower);
    }

    @Override
    public String toString() {
        return "[Magazine] " + super.toString() + " | Issue: " + issue
                + " | " + month;
    }
}