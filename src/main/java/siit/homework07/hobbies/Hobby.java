package siit.homework07.hobbies;

import siit.homework07.addresses.Address;

import java.util.List;

/**
 * This is a Hobby. It has 3 properties:
 * <p>
 * Name of hobby (String) – eq: cycling, swimming
 * Frequency (int) – how many times a week they practice it
 * List of Addresses where this hobby can be practiced (List<Adresa>)
 */
public class Hobby {
    String hobby;
    Integer frequency;
    List<Address> location;

    /**
     * Creates a hobby.
     *
     * @param hobby     the name of the hobby
     * @param frequency the number of times practiced per week
     * @param location  the list of locations where it can be practiced
     * @throws IllegalArgumentException if any of the parameters is null
     */
    public Hobby(String hobby, Integer frequency, List<Address> location) {
        if (hobby == null) {
            throw new IllegalArgumentException("the hobby needs to have a name");
        }
        this.hobby = hobby;
        if (frequency == null) {
            throw new IllegalArgumentException("everybody needs to have a name");
        }
        this.frequency = frequency;
        if (location == null) {
            throw new IllegalArgumentException("everybody needs to have a name");
        }
        this.location = location;
    }

    public String getHobby() {
        return hobby;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Address> getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby='" + hobby + '\'' +
                ", frequency=" + frequency +
                ", location=" + location +
                '}';
    }
}
