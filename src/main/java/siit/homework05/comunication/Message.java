package siit.homework05.comunication;

/**
 * This is a message. It has a phone number and a message content.
 */
public class Message {
    private String phoneNumber;
    private String messageContent;

    /**
     * Creates a message with phone number and content
     *
     * @param phoneNumber    the phone number to send the message to
     * @param messageContent the message content to be sent
     */
    public Message(String phoneNumber, String messageContent) {
        this.phoneNumber = phoneNumber;
        this.messageContent = messageContent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessageContent() {
        return messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}
