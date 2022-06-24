package siit.homework03;

/**
 *
 */
public class Main {
    /**
     * main method
     * @param args unused
     */
    public static void main(String[] args) {
        Book book1 = new Book(1, "First book", 400);
        Book book2 = new Novel(2, "First novel", 120, "love");
        Book book3 = new Novel(3, "Second novel", 200, "mystery");
        Book book4 = new ArtAlbum(4, "Album 1", 80, "Recycled paper");
        Book book5 = new ArtAlbum(5, "Album 2", 30, "Recycled paper");

        LibraryCatalog catalog = new LibraryCatalog(100);
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(book3);
        catalog.add(book4);
        catalog.add(book5);
        System.out.println("Library catalog");
        catalog.list();
        System.out.println("After delete");
        catalog.delete(book2);
        catalog.list();
    }
}

