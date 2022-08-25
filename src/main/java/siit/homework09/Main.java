package siit.homework09;

public class Main {

    public static final int NUMBER_OF_ATTENDEES = 150000;

    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);
        festivalStatisticsThread.start();

        for (int i = 0; i < NUMBER_OF_ATTENDEES; i++) {
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(TicketType.getRandomTicketType(), gate /* , i */);
            attendee.start();

        }

    }


}
