package siit.homework02;

/**
 * Pretty prints stuff.
 */
public class PrettyPrinter {
    /**
     * Displays Sales Representatives and a message.
     *
     * @param representatives       a list of {@link SalesRepresentative}.
     * @param beforePrintingMessage a message to be printed before the list.
     */
    public void display(SalesRepresentative[] representatives, String beforePrintingMessage) {
        System.out.println(beforePrintingMessage);
        for (int i = 0; i < representatives.length; i++) {
            System.out.println(representatives[i]);

        }
    }
}
