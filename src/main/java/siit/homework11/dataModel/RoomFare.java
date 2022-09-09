package siit.homework11.dataModel;

public class RoomFare {
    private Integer id;
    private Double value;
    private String season;

    public RoomFare(Integer id, Double value, String season) {
        this.id = id;
        this.value = value;
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomFare roomFair = (RoomFare) o;

        if (id != null ? !id.equals(roomFair.id) : roomFair.id != null) return false;
        if (value != null ? !value.equals(roomFair.value) : roomFair.value != null) return false;
        return season != null ? season.equals(roomFair.season) : roomFair.season == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return "RoomFare{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
