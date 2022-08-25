package siit.homework09;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * This is a festival gate that tracks the tickets. Uses a PriorityBlockingQueue to do so to avoid race conditions
 */
public class FestivalGate {
    private Queue<TicketType> queue;

    public FestivalGate() {
        queue = new PriorityBlockingQueue<>();
    }

    public void add(TicketType ticketType) {
        queue.add(ticketType);
    }

    public Queue<TicketType> getQueue() {
        return queue;
    }
}
