package siit.homework02;

/**
 * This is the main entry into the program.
 */
public class Main {
    /**
     * The main entry into the program.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        SalesRepresentative representative1 = new SalesRepresentative(10, 5000, 500);
        SalesRepresentative representative2 = new SalesRepresentative(7, 5600, 800);
        SalesRepresentative representative3 = new SalesRepresentative(1, 200, 10);
        SalesRepresentative representative4 = new SalesRepresentative(5, 600, 70);
        SalesRepresentative representative5 = new SalesRepresentative(5, 6000, 70);
        SalesRepresentative[] representatives = new SalesRepresentative[5];
        representatives[0] = representative1;
        representatives[1] = representative2;
        representatives[2] = representative3;
        representatives[3] = representative4;
        representatives[4] = representative5;

        PrettyPrinter print = new PrettyPrinter();
        print.display(representatives, "before");

        BubbleSorter bubble = new BubbleSorter();
        bubble.sort(representatives, false);

        print.display(representatives, "after");
    }
}
