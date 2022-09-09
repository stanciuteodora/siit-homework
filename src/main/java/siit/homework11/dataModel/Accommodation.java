package siit.homework11.dataModel;

import java.util.List;

public class Accommodation {

    private Integer id;
    private String type;
    private String bedType;
    private Integer maxGuests;
    private String description;
    private List<RoomFare> fares;

    public Accommodation(Integer id, String type, String bedType, Integer maxGuests, String description, List<RoomFare> fares) {
        this.id = id;
        this.type = type;
        this.bedType = bedType;
        this.maxGuests = maxGuests;
        this.description = description;
        this.fares = fares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accommodation that = (Accommodation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (bedType != null ? !bedType.equals(that.bedType) : that.bedType != null) return false;
        if (maxGuests != null ? !maxGuests.equals(that.maxGuests) : that.maxGuests != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (bedType != null ? bedType.hashCode() : 0);
        result = 31 * result + (maxGuests != null ? maxGuests.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBedType() {
        return bedType;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public String getDescription() {
        return description;
    }

    public List<RoomFare> getFares() {
        return fares;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", bedType='" + bedType + '\'' +
                ", maxGuests=" + maxGuests +
                ", description='" + description + '\'' +
                ", fares=" + fares +
                '}';
    }
}
