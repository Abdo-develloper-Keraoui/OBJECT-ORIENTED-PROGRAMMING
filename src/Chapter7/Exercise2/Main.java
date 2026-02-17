package Chapter7.Exercise2;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The hobbit", "J. R. R. Tolkien", 350);
        Book book2 = new Book("The return of the king", "J. R. R. Tolkien", 400);
        Book book3 = new Book("The adventures of Tom Sawyer", "Mark Twain", 250);

        System.out.println(book1);
        System.out.println("\n" + book2);
        System.out.println("\n" + book3);

        book1.markAsRead();

        System.out.println("\n" + book1);

    }
}
