package siit.homework05.phones;

import siit.homework05.contacts.Contact;

/**
 * This is a communication device.
 * It allows to add contacts, list contacts, send messages, list the sent messages,
 * call contacts or numbers, see the call history.
 */
public interface CommunicationDevices {
    /**
     * Adds a contact to a phone. The user has to fill all the fields.
     *
     * @param index       the index of the contact;
     * @param phoneNumber the phone number of that contact;
     * @param firstName   the first name of the contact;
     * @param lastName    the last name of the contact;
     */
    void addContact(int index, String phoneNumber, String firstName, String lastName);

    /**
     * Adds a contact to a phone. The contact already has all the fields completed( ex. a contact received via sms from
     * somebody else).
     *
     * @param contact the contact information;
     */
    void addContact(Contact contact);

    /**
     * Lists the contacts.
     */
    void listContacts();

    /**
     * Sends a message to a phone number.
     *
     * @param phoneNumber    the phone number;
     * @param messageContent the content of the message;
     */
    void sendMessage(String phoneNumber, String messageContent);

    /**
     * Sends a message to a contact from the phone.
     *
     * @param contact        the contact who receive the message;
     * @param messageContent the content of the message;
     */
    void sendMessage(Contact contact, String messageContent);

    /**
     * Lists the messages sent to a phone number.
     *
     * @param phoneNumber the phone number to which the messages were sent;
     */
    void listMessages(String phoneNumber);

    /**
     * Lists the messages sent to a contact.
     *
     * @param contact the contact to which the messages were sent;
     */
    void listMessages(Contact contact);

    /**
     * Makes a call to a phone number.
     *
     * @param phoneNumber the phone number to call;
     */
    void call(String phoneNumber);

    /**
     * Makes a call to a contact.
     *
     * @param contact the contact to which the call is made;
     */
    void call(Contact contact);

    /**
     * Lists the history of the calls.
     */
    void viewHistory();
}
