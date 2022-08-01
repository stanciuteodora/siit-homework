package siit.homework07.addresses;

/**
 * This is an address.
 */
public class Address {
    private Country country;

    /**
     * Creates an address.
     *
     * @param country the country of the address
     */
    public Address(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                '}';
    }

}
