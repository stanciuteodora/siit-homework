package siit.homework03;

/**
 * This is a library catalog that lists, adds and deletes books.
 */
public class LibraryCatalog {
    private Book[] books;
    private Integer size;

    /**
     * Creates a catalog of {@link Book}. The catalog has a fixed capacity which indicates the maximum number
     * of books that it can store( not to be confused with size which is number of books in the catalog).
     *
     * @param capacity the maximum number of books that can be stored.
     */
    public LibraryCatalog(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    /**
     * Adds a book in the library catalog. Allows duplicates to be stored.
     *
     * @param book the book which will be added.
     */
    public void add(Book book) {
        books[size] = book;
        size++;
    }

    /**
     * Displays the list of the books in the library catalog.
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    /**
     * Deletes a book in the library catalog. Deletes all references to that book.
     *
     * @param book the book to be deleted
     */
    public void delete(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == book.getId()) {
                for (int k = i; k < size - 1; k++) {
                    books[k] = books[k + 1];
                }
                books[size] = null;
                size = size - 1;
            }
        }
    }

    /**
     * Finds a book given its id.
     *
     * @param id the id of the book.
     * @return returns the book if found, else null.
     */
    public Book findById(int id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }

    /**
     * Gets the number of books in the library catalog; not to be confused with capacity.
     *
     * @return returns the size of the library catalog.
     */
    public Integer getSize() {
        return size;
    }
}
