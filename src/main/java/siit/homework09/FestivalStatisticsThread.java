package siit.homework09;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the festival statistics thread. It generates statistics after reading data from the gate.
 */
public class FestivalStatisticsThread extends Thread {
    public static final int FIVE_SECONDS = 5000;
    private FestivalGate gate;
    private int totalAttendees;
    private Map<TicketType, Integer> ticketStats;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
        this.totalAttendees = 0;
        this.ticketStats = new HashMap<>();
    }

    /**
     * Updates the statistics, prints them and sleeps for 5 seconds
     */
    @Override
    public void run() {
        while (true) {
            updateStats();
            printStats();
            sleep();
        }
    }

    /**
     * Updates the statistics
     */
    public void updateStats() {
        TicketType ticketType = gate.getQueue().poll();
        while (ticketType != null) {
            if (ticketStats.containsKey(ticketType)) {
                Integer currentValue = ticketStats.get(ticketType);
                currentValue++;
                ticketStats.put(ticketType, currentValue);
            } else {
                ticketStats.put(ticketType, 1);
            }
            totalAttendees++;
            ticketType = gate.getQueue().poll();
        }
    }

    /**
     * Prints the stats
     */
    public void printStats() {
        System.out.println(totalAttendees + " people entered");
        System.out.println(ticketStats);
    }

    private void sleep() {
        try {
            sleep(FIVE_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<TicketType, Integer> getTicketStats() {
        return ticketStats;
    }
}
