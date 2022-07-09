package siit.homework05.comunication;

/**
 * This is a call. It has a phone number.
 */
public class Call {
    private String phoneNumber;

    /**
     * Creates a call with phone number.
     *
     * @param phoneNumber the phone number
     */
    public Call(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Call{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
