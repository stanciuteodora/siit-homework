package siit.homework10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework10.dataAccess.RaceResultParser;
import siit.homework10.dataModel.RaceResult;

import javax.xml.datatype.Duration;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceResultParserTest {
    @Test
    public void happyCase() {
        // data preparation
        String fileContent = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";

        // test execution
        RaceResultParser raceResultParser = new RaceResultParser();
        RaceResult raceResult = raceResultParser.parseRaceResult(fileContent);

        // assertions
        Assertions.assertEquals(11, raceResult.getBiathlonAthlete().getAthleteNumber());
        Assertions.assertEquals("Umar Jorgson", raceResult.getBiathlonAthlete().getName());
        Assertions.assertEquals("SK", raceResult.getBiathlonAthlete().getCountryCode());
        Assertions.assertEquals("PT30M27S", raceResult.getTime().toString());
        Assertions.assertEquals(Arrays.asList("xxxox", "xxxxx", "xxoxo"), raceResult.getShootingRangeResults());
        Assertions.assertEquals("PT30S", raceResult.getPenalties().toString());
        Assertions.assertEquals("PT30M57S", raceResult.getTimeWithPenalties().toString());
    }

    @Test
    public void testPerfectShooting() {
        // data preparation
        String fileContent = "11,Umar Jorgson,SK,30:27,xxxxx,xxxxx,xxxxx";

        // test execution
        RaceResultParser raceResultParser = new RaceResultParser();
        RaceResult raceResult = raceResultParser.parseRaceResult(fileContent);

        // assertions
        Assertions.assertEquals(11, raceResult.getBiathlonAthlete().getAthleteNumber());
        Assertions.assertEquals("Umar Jorgson", raceResult.getBiathlonAthlete().getName());
        Assertions.assertEquals("SK", raceResult.getBiathlonAthlete().getCountryCode());
        Assertions.assertEquals("PT30M27S", raceResult.getTime().toString());
        Assertions.assertEquals(Arrays.asList("xxxxx", "xxxxx", "xxxxx"), raceResult.getShootingRangeResults());
        Assertions.assertEquals("PT0S", raceResult.getPenalties().toString());
        Assertions.assertEquals("PT30M27S", raceResult.getTimeWithPenalties().toString());
    }

    @Test
    public void testZeroTime() {
        // data preparation
        String fileContent = "11,Umar Jorgson,SK,00:00,xxxxx,xxxxx,xxxxx";

        // test execution
        RaceResultParser raceResultParser = new RaceResultParser();
        RaceResult raceResult = raceResultParser.parseRaceResult(fileContent);

        // assertions
        Assertions.assertEquals(11, raceResult.getBiathlonAthlete().getAthleteNumber());
        Assertions.assertEquals("Umar Jorgson", raceResult.getBiathlonAthlete().getName());
        Assertions.assertEquals("SK", raceResult.getBiathlonAthlete().getCountryCode());
        Assertions.assertEquals("PT0S", raceResult.getTime().toString());
        Assertions.assertEquals(Arrays.asList("xxxxx", "xxxxx", "xxxxx"), raceResult.getShootingRangeResults());
        Assertions.assertEquals("PT0S", raceResult.getPenalties().toString());
        Assertions.assertEquals("PT0S", raceResult.getTimeWithPenalties().toString());
    }

    @Test
    public void testNoAthleteNumber() {
        // data preparation
        String fileContent = " ,Umar Jorgson,SK,00:00,xxxxx,xxxxx,xxxxx";

        RaceResultParser raceResultParser = new RaceResultParser();

        Assertions.assertThrows(NumberFormatException.class, () -> raceResultParser.parseRaceResult(fileContent));
    }

    @Test
    public void testNoAthleteName() {
        // data preparation
        String fileContent = "11,,SK,30:27,xxxox,xxxxx,xxoxo";

        // test execution
        RaceResultParser raceResultParser = new RaceResultParser();
        RaceResult raceResult = raceResultParser.parseRaceResult(fileContent);

        // assertions
        Assertions.assertEquals(11, raceResult.getBiathlonAthlete().getAthleteNumber());
        Assertions.assertEquals("", raceResult.getBiathlonAthlete().getName());
        Assertions.assertEquals("SK", raceResult.getBiathlonAthlete().getCountryCode());
        Assertions.assertEquals("PT30M27S", raceResult.getTime().toString());
        Assertions.assertEquals(Arrays.asList("xxxox", "xxxxx", "xxoxo"), raceResult.getShootingRangeResults());
        Assertions.assertEquals("PT30S", raceResult.getPenalties().toString());
        Assertions.assertEquals("PT30M57S", raceResult.getTimeWithPenalties().toString());
    }
}
