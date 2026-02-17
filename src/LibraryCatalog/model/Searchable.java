package LibraryCatalog.model;

public interface Searchable {

    boolean matchesQuery(String query);
}