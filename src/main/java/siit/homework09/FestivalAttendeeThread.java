package siit.homework09;

/**
 * This is a festival attendee thread. Every attendee validates the ticket, and the ticket-data is kept in a queue.
 */

public class FestivalAttendeeThread extends Thread {
    // should be 1 second, but I made it shorter to get results faster
    public static final int ONE_SECOND = 100;
    private TicketType ticketType;
    private FestivalGate gate;
    // private int id;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate /*, int id */) {
        this.ticketType = ticketType;
        this.gate = gate;
//        this.id = id;
    }

    /**
     * Sleeps for 1 second and validate the tickets.
     */
    @Override
    public void run() {
        sleep();
//        System.out.println("I am " + id);
        validate();
    }

    private void sleep() {
        try {
            sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Validates the tickets.
     */
    public void validate() {
        gate.add(ticketType);

    }

    @Override
    public String toString() {
        return "FestivalAttendeeThread{" +
                "ticketType=" + ticketType +
                ", gate=" + gate +
                '}';
    }
}
