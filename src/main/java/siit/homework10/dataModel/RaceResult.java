package siit.homework10.dataModel;

import java.time.Duration;
import java.util.List;

/**
 * This is a race result.
 */
public class RaceResult {
    private BiathlonAthlete biathlonAthlete;
    private Duration time;
    private Duration timeWithPenalties;
    private Duration penalties;
    private List<String> shootingRangeResults;

    /**
     * Creates a race result.
     *
     * @param biathlonAthlete      the biathlon athlete
     * @param time                 the race results of the biathlon athlete
     * @param shootingRangeResults the shooting range results of the biathlon athlete
     */

    public RaceResult(BiathlonAthlete biathlonAthlete, Duration time, List<String> shootingRangeResults) {
        this.time = time;
        this.shootingRangeResults = shootingRangeResults;
        this.biathlonAthlete = biathlonAthlete;
        this.penalties = computePenalties();
        this.timeWithPenalties = time.plus(penalties);
    }

    /**
     * Calculates the time penalties after the shooting range results
     *
     * @return the penalties
     */
    private Duration computePenalties() {
        Duration penalties = Duration.ZERO;
        for (String eachShootingRange : shootingRangeResults) {
            for (int i = 0; i < eachShootingRange.length(); i++) {
                if (eachShootingRange.charAt(i) == 'o') {
                    penalties = penalties.plusSeconds(10);
                }
            }
        }
        return penalties;
    }

    public Duration getTime() {
        return time;
    }

    public Duration getTimeWithPenalties() {
        return timeWithPenalties;
    }

    public BiathlonAthlete getBiathlonAthlete() {
        return biathlonAthlete;
    }

    public Duration getPenalties() {
        return penalties;
    }

    public List<String> getShootingRangeResults() {
        return shootingRangeResults;
    }


    @Override
    public String toString() {
        return biathlonAthlete +
                " " + timeWithPenalties +
                " " + '(' + time +
                " + " + penalties + ')';
    }
}

