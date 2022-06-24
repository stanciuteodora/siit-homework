package siit.homework03;

/**
 * This is a book. Each book has an id, name and number of pages.
 */
public class Book {
    protected String name;
    protected int numberOfPages;
    protected int id;

    /**
     * Creates a book with an id, name and number of pages.
     *
     * @param id            the id of the book.
     * @param name          the name of the book.
     * @param numberOfPages the number of pages of the book.
     */
    public Book(int id, String name, int numberOfPages) {
        this.id = id;
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
