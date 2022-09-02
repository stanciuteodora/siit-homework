package siit.homework10;

import siit.homework10.dataModel.RaceResult;

import java.time.Duration;
import java.util.Comparator;

/**
 * A comparator for {@link RaceResult}; compares the objects by time with penalties.
 */
public class TimeWithPenaltiesComparator implements Comparator<RaceResult> {
    /**
     * Compares two objects by time with penalties
     *
     * @param r1 the first object to be compared.
     * @param r2 the second object to be compared.
     * @return the comparator value, negative if less, positive if greater, 0 if equal
     */
    @Override
    public int compare(RaceResult r1, RaceResult r2) {
        Duration r1TimeWithPenalties = r1.getTimeWithPenalties();
        Duration r2TimeWithPenalties = r2.getTimeWithPenalties();
        return r1TimeWithPenalties.compareTo(r2TimeWithPenalties);
    }
}
