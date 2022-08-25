package siit.homework09;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class FestivalStatisticsThreadTest {
    @Test
    public void testHappyCase() {
        // data preparation
        FestivalGate gate = new FestivalGate();
        gate.add(TicketType.FULL_VIP);
        gate.add(TicketType.ONE_DAY);
        gate.add(TicketType.ONE_DAY);

        // test execution
        FestivalStatisticsThread unitUnderTest = new FestivalStatisticsThread(gate);
        unitUnderTest.updateStats();

        // assertions
        Map<TicketType, Integer> ticketStats = unitUnderTest.getTicketStats();
        Assertions.assertEquals(2, ticketStats.get(TicketType.ONE_DAY));
        Assertions.assertEquals(1, ticketStats.get(TicketType.FULL_VIP));
        Assertions.assertEquals(2, ticketStats.size());
        Assertions.assertFalse(ticketStats.containsKey(TicketType.FULL));
    }

    @Test
    public void testZeroAttendees() {
        // data preparation
        FestivalGate gate = new FestivalGate();

        // test execution
        FestivalStatisticsThread unitUnderTest = new FestivalStatisticsThread(gate);
        unitUnderTest.updateStats();

        // assertions
        Map<TicketType, Integer> ticketStats = unitUnderTest.getTicketStats();
        Assertions.assertEquals(0, ticketStats.size());
        Assertions.assertFalse(ticketStats.containsKey(TicketType.FULL));
        Assertions.assertFalse(ticketStats.containsKey(TicketType.FULL_VIP));
        Assertions.assertFalse(ticketStats.containsKey(TicketType.FREE_PASS));
        Assertions.assertFalse(ticketStats.containsKey(TicketType.ONE_DAY_VIP));
        Assertions.assertFalse(ticketStats.containsKey(TicketType.ONE_DAY));
    }

    @Test
    public void testAllTypesAttendees() {
        // data preparation
        FestivalGate gate = new FestivalGate();
        gate.add(TicketType.FULL_VIP);
        gate.add(TicketType.ONE_DAY);
        gate.add(TicketType.ONE_DAY);
        gate.add(TicketType.FULL);
        gate.add(TicketType.FULL);
        gate.add(TicketType.FULL);
        gate.add(TicketType.FREE_PASS);
        gate.add(TicketType.FREE_PASS);
        gate.add(TicketType.FREE_PASS);
        gate.add(TicketType.FREE_PASS);
        gate.add(TicketType.ONE_DAY_VIP);
        gate.add(TicketType.ONE_DAY_VIP);
        gate.add(TicketType.ONE_DAY_VIP);
        gate.add(TicketType.ONE_DAY_VIP);
        gate.add(TicketType.ONE_DAY_VIP);

        // test execution
        FestivalStatisticsThread unitUnderTest = new FestivalStatisticsThread(gate);
        unitUnderTest.updateStats();

        // assertions
        Map<TicketType, Integer> ticketStats = unitUnderTest.getTicketStats();
        Assertions.assertEquals(2, ticketStats.get(TicketType.ONE_DAY));
        Assertions.assertEquals(1, ticketStats.get(TicketType.FULL_VIP));
        Assertions.assertEquals(3, ticketStats.get(TicketType.FULL));
        Assertions.assertEquals(4, ticketStats.get(TicketType.FREE_PASS));
        Assertions.assertEquals(5, ticketStats.get(TicketType.ONE_DAY_VIP));
        Assertions.assertEquals(5, ticketStats.size());
    }

}
