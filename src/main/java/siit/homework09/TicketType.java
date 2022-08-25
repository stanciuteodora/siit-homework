package siit.homework09;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;


    public static TicketType getRandomTicketType() {
        TicketType[] values = TicketType.values();
        Random random = new Random();
        int i = random.nextInt(values.length);
        return values[i];
    }
}
