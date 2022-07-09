package siit.homework05.contacts;

/**
 * This is a contact. Each contact has an index, phone number, first name and last name.
 */
public class Contact {
    private int index;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    /**
     * Creates a contact
     *
     * @param index       the index
     * @param phoneNumber the phone number
     * @param firstName   the first name
     * @param lastName    the last name
     */
    public Contact(int index, String phoneNumber, String firstName, String lastName) {
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIndex() {
        return index;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "index=" + index +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
