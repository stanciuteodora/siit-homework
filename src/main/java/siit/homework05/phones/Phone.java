package siit.homework05.phones;

import siit.homework05.comunication.Call;
import siit.homework05.comunication.Message;
import siit.homework05.contacts.Contact;

import java.util.ArrayList;

/**
 * This is a phone. Each phone implements {@link CommunicationDevices} and has:
 * - properties which cannot change: battery life (in number of hours)
 * - properties that are configurable: color, material
 * - properties that are instance specific: imei, contacts, messages, calls
 */
public class Phone implements CommunicationDevices {
    protected double batteryLife;
    protected String color;
    protected String material;
    protected String imei;
    private ArrayList<Contact> contacts;
    private ArrayList<Message> messages;
    private ArrayList<Call> calls;

    /**
     * Creates a phone with material, color and imei.
     * Sets the contacts, calls and messages to empty lists.
     *
     * @param color    the color
     * @param material the material
     * @param imei     the imei
     */
    public Phone(String color, String material, String imei) {
        this.color = color;
        this.material = material;
        this.imei = imei;
        this.contacts = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.calls = new ArrayList<>();
    }

    /**
     * Adds a contact to the phone given an index, phone number, first name and last name.
     *
     * @param index       the index of the contact;
     * @param phoneNumber the phone number of that contact;
     * @param firstName   the first name of the contact;
     * @param lastName    the last name of the contact;
     */
    @Override
    public void addContact(int index, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(index, phoneNumber, firstName, lastName);
        addContact(contact);
    }

    /**
     * Adds the contact to the phone.
     *
     * @param contact the contact information;
     */
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("am adaugat cu succes contactul" + contact);
    }

    /**
     * Lists the contacts added to the phone.
     */
    @Override
    public void listContacts() {
        System.out.println("[");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
        System.out.println("]");
//        System.out.println(contacts);
    }

    /**
     * Sends a message given a phone number and a message content.
     * Every time a message is sent an hour is taken from the battery life.
     * The phone has to have enough battery.
     * The message is cut to 500 characters if it's longer.
     *
     * @param phoneNumber    the phone number;
     * @param messageContent the content of the message;
     * @throws RuntimeException if the phone is dead (no battery to send the message)
     */
    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (batteryLife < 1) {
            throw new RuntimeException("your phone doesn't have enough battery");
        }
        batteryLife--;

        Message message = new Message(phoneNumber, messageContent);
        if (messageContent.length() > 500) {
            messageContent = messageContent.substring(0, 500);
        }
        messages.add(message);

        System.out.println(messageContent);
        System.out.println("remaining battery life is: " + batteryLife);
    }

    /**
     * Given a contact and a message content, it sends a message to the contact.
     *
     * @param contact        the contact who receive the message;
     * @param messageContent the content of the message;
     */
    @Override
    public void sendMessage(Contact contact, String messageContent) {
        String phoneNumber = contact.getPhoneNumber();
        sendMessage(phoneNumber, messageContent);
    }

    /**
     * Lists the messages sent to a phone number.
     *
     * @param phoneNumber the phone number to which the messages were sent;
     */
    @Override
    public void listMessages(String phoneNumber) {
        System.out.println("these are you messages: ");
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            if (phoneNumber.equals(message.getPhoneNumber())) {
                System.out.println(message);
            }
        }
    }

    /**
     * Lists the messages sent to a contact.
     *
     * @param contact the contact to which the messages were sent;
     */
    @Override
    public void listMessages(Contact contact) {
        listMessages(contact.getPhoneNumber());
    }

    /**
     * Gets the contacts.
     *
     * @return the contacts;
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * Makes a call to a phone number.
     * Every time a call is made two hours are taken from the battery life.
     *
     * @param phoneNumber the phone number to call;
     * @throws RuntimeException if the battery level does not allow to make the call
     */
    @Override
    public void call(String phoneNumber) {
        if (batteryLife < 2) {
            throw new RuntimeException("your phone doesn't have enough battery");
        }
        batteryLife = batteryLife - 2;
        Call call = new Call(phoneNumber);
        calls.add(call);
        System.out.println("remaining battery level is: " + batteryLife);
    }

    /**
     * Makes a call to a contact.
     *
     * @param contact the contact to which the call is made;
     */
    @Override
    public void call(Contact contact) {
        call(contact.getPhoneNumber());
    }

    /**
     * Call history of the phone.
     */
    @Override
    public void viewHistory() {
        System.out.println("These are your calls: ");
        displayCallHistory(null);
    }

    /**
     * Call history from a contact of the phone.
     *
     * @param contact the contact whose calls are selected from the history;
     */
    public void viewHistory(Contact contact) {
        System.out.println("These are your calls to " + contact.getFirstName() + ' ' + contact.getLastName() + ": ");
        String phoneNumber = contact.getPhoneNumber();
        displayCallHistory(phoneNumber);
    }

    /**
     * Call history from a phone number.
     *
     * @param phoneNumber the phone number whose calls are selected from the history;
     */
    public void viewHistory(String phoneNumber) {
        System.out.println("These are your calls to " + phoneNumber + ": ");
        displayCallHistory(phoneNumber);
    }

    /**
     * Displays the call history.
     *
     * @param phoneNumber the contact whose calls are to be displayed;
     */
    private void displayCallHistory(String phoneNumber) {
        for (int i = 0; i < calls.size(); i++) {
            Call call = calls.get(i);
            if (phoneNumber == null) {
                System.out.println(calls.get(i));
            } else if (phoneNumber.equals(call.getPhoneNumber())) {
                System.out.println(calls.get(i));
            }
        }
    }
}
