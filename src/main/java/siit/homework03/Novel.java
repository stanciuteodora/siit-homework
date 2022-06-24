package siit.homework03;

/**
 * This is a novel. Each novel extends {@link Book} and adds a type.
 */
public class Novel extends Book {
    private String type;

    /**
     * Creates a novel with an id, name, number of pages and a type.
     *
     * @param id            the id of the novel.
     * @param name          the name of the novel.
     * @param numberOfPages the number of pages of the novel.
     * @param type          the type of the novel.
     */
    public Novel(int id, String name, int numberOfPages, String type) {
        super(id, name, numberOfPages);
        this.type = type;

    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id='" + id + '\'' +
                ", name='" + name + "', " +
                "numberOfPages='" + numberOfPages + "', " +
                "type='" + type + '\'' +
                '}';
    }
}
