package siit.homework07.addresses;

/**
 * This is a country.
 */
public class Country {
    private String name;
    private String isoCode;

    /**
     * Creates a country with name and iso code.
     *
     * @param name    the name of the country
     * @param isoCode the code
     */
    public Country(String name, String isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", isoCode='" + isoCode + '\'' +
                '}';
    }
}
