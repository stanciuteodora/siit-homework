package siit.homework03;

/**
 * This is an art album. Each art album extends {@link Book} and adds the paper quality.
 */
public class ArtAlbum extends Book {
    private String paperQuality;

    /**
     * Creates a book with an id, name, number of pages and paper quality.
     *
     * @param id            the id of the art album.
     * @param name          the name of the art album.
     * @param numberOfPages the number of pages of the art album.
     * @param paperQuality  the quality of the paper of the art album.
     */
    public ArtAlbum(int id, String name, int numberOfPages, String paperQuality) {
        super(id, name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbum{" +
                "id='" + id + '\'' +
                ", name='" + name + "', " +
                "numberOfPages='" + numberOfPages + "', " +
                "paperQuality='" + paperQuality + '\'' +
                '}';
    }
}
