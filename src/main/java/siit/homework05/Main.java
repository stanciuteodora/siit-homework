package siit.homework05;


import siit.homework05.phones.Phone;
import siit.homework05.phones.SamsungGalaxyS6;

/**
 *
 */

public class Main {
    /**
     * main method
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Phone phone1 = new SamsungGalaxyS6("red", "metal", "1234567891");
        phone1.addContact(1, "0745678987", "John", "Doe");
        phone1.addContact(2, "0723456798", "Jane", "Doe");
        phone1.listContacts();

        phone1.sendMessage("0745678987", "This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 charactersAici se taie mesajul");
        phone1.sendMessage(phone1.getContacts().get(0), "This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 characters message. This is a 500 charactersAici se taie mesajul");
        phone1.sendMessage("0723456798", "abc");
        phone1.sendMessage("0745678987", "qed");

        phone1.listMessages("0745678987");
        phone1.listMessages(phone1.getContacts().get(0));

        phone1.call(phone1.getContacts().get(1));
        phone1.call(phone1.getContacts().get(0));
        phone1.call(phone1.getContacts().get(1));

        phone1.viewHistory();
        phone1.viewHistory(phone1.getContacts().get(1));

        phone1.call("0723123456");
    }
}
