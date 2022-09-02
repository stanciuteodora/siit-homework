package siit.homework10.dataAccess;

import siit.homework10.dataModel.BiathlonAthlete;
import siit.homework10.dataModel.RaceResult;

import java.time.Duration;
import java.util.Arrays;

/**
 * This is a race result parser.
 */
public class RaceResultParser {
    /**
     * Creates {@link RaceResult} given a line.
     * expected format:
     * AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShootingRange
     * example:
     * 11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo
     *
     * @param line the line to parse
     * @return the result
     */
    public RaceResult parseRaceResult(String line) {
        String[] elements = line.split(",");
        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(Integer.parseInt(elements[0]), elements[1], elements[2]);
        return new RaceResult(biathlonAthlete, getDuration(elements[3]), Arrays.asList(elements[4], elements[5], elements[6]));
    }

    private static Duration getDuration(String raceTime) {
        String[] raceTimeElements = raceTime.split(":");
        Duration duration = Duration.ZERO;
        duration = duration.plusMinutes(Long.parseLong(raceTimeElements[0]));
        duration = duration.plusSeconds(Long.parseLong(raceTimeElements[1]));
        return duration;
    }
}
