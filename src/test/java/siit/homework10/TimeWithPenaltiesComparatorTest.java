package siit.homework10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework10.dataModel.BiathlonAthlete;
import siit.homework10.dataModel.RaceResult;

import java.time.Duration;
import java.util.Arrays;

public class TimeWithPenaltiesComparatorTest {
    @Test
    public void testGreater() {
        TimeWithPenaltiesComparator comparator = new TimeWithPenaltiesComparator();
        RaceResult r1 = new RaceResult(new BiathlonAthlete(11, "Umar Jorgson", "SK"), getDuration("30:27"), Arrays.asList("xxxox", "xxxxx", "xxoxo"));
        RaceResult r2 = new RaceResult(new BiathlonAthlete(1, "Jimmy Smiles", "UK"), getDuration("29:15"), Arrays.asList("xxoox", "xooxo", "xxxxo"));

        int expected = 1;
        int actual = comparator.compare(r1, r2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testEqual() {
        TimeWithPenaltiesComparator comparator = new TimeWithPenaltiesComparator();
        RaceResult r1 = new RaceResult(new BiathlonAthlete(11, "Umar Jorgson", "SK"), getDuration("30:27"), Arrays.asList("xxxox", "xxxxx", "xxoxo"));
        RaceResult r2 = new RaceResult(new BiathlonAthlete(11, "Umar Jorgson", "SK"), getDuration("30:27"), Arrays.asList("xxxox", "xxxxx", "xxoxo"));

        int expected = 0;
        int actual = comparator.compare(r1, r2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSmaller() {
        TimeWithPenaltiesComparator comparator = new TimeWithPenaltiesComparator();
        RaceResult r1 = new RaceResult(new BiathlonAthlete(1, "Jimmy Smiles", "UK"), getDuration("29:15"), Arrays.asList("xxoox", "xooxo", "xxxxo"));
        RaceResult r2 = new RaceResult(new BiathlonAthlete(11, "Umar Jorgson", "SK"), getDuration("30:27"), Arrays.asList("xxxox", "xxxxx", "xxoxo"));

        int expected = -1;
        int actual = comparator.compare(r1, r2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testRaceResultNull() {
        TimeWithPenaltiesComparator comparator = new TimeWithPenaltiesComparator();
        RaceResult r1 = new RaceResult(new BiathlonAthlete(1, "Jimmy Smiles", "UK"), getDuration("29:15"), Arrays.asList("xxoox", "xooxo", "xxxxo"));
        RaceResult r2 = null;

        Assertions.assertThrows(NullPointerException.class, () -> comparator.compare(r1, r2));
    }

    private static Duration getDuration(String raceTime) {
        String[] raceTimeElements = raceTime.split(":");
        Duration duration = Duration.ZERO;
        duration = duration.plusMinutes(Long.parseLong(raceTimeElements[0]));
        duration = duration.plusSeconds(Long.parseLong(raceTimeElements[1]));
        return duration;
    }
}

