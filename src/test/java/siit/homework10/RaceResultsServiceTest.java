package siit.homework10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework10.dataAccess.RaceResultsCsvDao;
import siit.homework10.dataAccess.RaceResultsDao;
import siit.homework10.dataModel.BiathlonAthlete;
import siit.homework10.dataModel.RaceResult;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceResultsServiceTest {

    @Test
    public void testWinWithDifferentShootingResults() {
        // data preparation
        RaceResultsDao raceResultsDao = new RaceResultsCsvDao("athletes.csv");
        RaceResultsService raceResultsService = new RaceResultsService(raceResultsDao);

        // test execution
        List<RaceResult> sortedResults = raceResultsService.getSortedResults();

        // assertions
        BiathlonAthlete umar = new BiathlonAthlete(11, "Umar Jorgson", "SK");
        BiathlonAthlete jimmy = new BiathlonAthlete(1, "Jimmy Smiles", "UK");
        BiathlonAthlete piotr = new BiathlonAthlete(27, "Piotr Smitzer", "CZ");
        BiathlonAthlete klas = new BiathlonAthlete(15, "Klas Lestander", "SE");
        BiathlonAthlete magnar = new BiathlonAthlete(5, "Magnar Solberg", "NO");

        RaceResult umarResult = new RaceResult(umar, getDuration("30:27"), Arrays.asList("xxxox", "xxxxx", "xxoxo"));
        RaceResult jimmyResult = new RaceResult(jimmy, getDuration("29:15"), Arrays.asList("xxoox", "xooxo", "xxxxo"));
        RaceResult piotrResult = new RaceResult(piotr, getDuration("30:10"), Arrays.asList("xxxxx", "xxxxx", "xxxxx"));
        RaceResult klasResult = new RaceResult(klas, getDuration("29:20"), Arrays.asList("xoxxx", "xxxox", "xxxxx"));
        RaceResult magnarResult = new RaceResult(magnar, getDuration("29:45"), Arrays.asList("xxoxx", "xooxx", "xxoxx"));

        List<RaceResult> expectedResult = new ArrayList<>();
        expectedResult.add(klasResult);
        expectedResult.add(piotrResult);
        expectedResult.add(jimmyResult);
        expectedResult.add(magnarResult);
        expectedResult.add(umarResult);
        Assertions.assertEquals(expectedResult.size(), sortedResults.size());
        for (int i = 0; i < expectedResult.size() && i < sortedResults.size(); i++) {
            RaceResult expected = expectedResult.get(i);
            RaceResult actual = sortedResults.get(i);
            Assertions.assertEquals(expected.getBiathlonAthlete().getAthleteNumber(), actual.getBiathlonAthlete().getAthleteNumber());
            if (i >= 1) {
                Duration currentTime = sortedResults.get(i).getTimeWithPenalties();
                Duration previousTime = sortedResults.get(i - 1).getTimeWithPenalties();
                Assertions.assertTrue(currentTime.compareTo(previousTime) > 0);
            }
        }
    }

    @Test
    public void testWinWithSameShootingResults() {
        // data preparation
        RaceResultsDao raceResultsDao = new RaceResultsCsvDao("athletes2.csv");
        RaceResultsService raceResultsService = new RaceResultsService(raceResultsDao);

        // test execution
        List<RaceResult> sortedResults = raceResultsService.getSortedResults();

        // assertions
        BiathlonAthlete umar = new BiathlonAthlete(11, "Umar Jorgson", "SK");
        BiathlonAthlete jimmy = new BiathlonAthlete(1, "Jimmy Smiles", "UK");
        BiathlonAthlete piotr = new BiathlonAthlete(27, "Piotr Smitzer", "CZ");
        BiathlonAthlete klas = new BiathlonAthlete(15, "Klas Lestander", "SE");
        BiathlonAthlete magnar = new BiathlonAthlete(5, "Magnar Solberg", "NO");

        RaceResult umarResult = new RaceResult(umar, getDuration("30:27"), Arrays.asList("xxxxx", "xxxxx", "xxxxx"));
        RaceResult jimmyResult = new RaceResult(jimmy, getDuration("29:15"), Arrays.asList("xxxxx", "xxxxx", "xxxxx"));
        RaceResult piotrResult = new RaceResult(piotr, getDuration("30:10"), Arrays.asList("xxxxx", "xxxxx", "xxxxx"));
        RaceResult klasResult = new RaceResult(klas, getDuration("29:20"), Arrays.asList("xxxxx", "xxxxx", "xxxxx"));
        RaceResult magnarResult = new RaceResult(magnar, getDuration("29:45"), Arrays.asList("xxxxx", "xxxxx", "xxxxx"));

        List<RaceResult> expectedResult = new ArrayList<>();
        expectedResult.add(jimmyResult);
        expectedResult.add(klasResult);
        expectedResult.add(magnarResult);
        expectedResult.add(piotrResult);
        expectedResult.add(umarResult);

        Assertions.assertEquals(expectedResult.size(), sortedResults.size());
        for (int i = 0; i < expectedResult.size() && i < sortedResults.size(); i++) {
            RaceResult expected = expectedResult.get(i);
            RaceResult actual = sortedResults.get(i);
            Assertions.assertEquals(expected.getBiathlonAthlete().getAthleteNumber(), actual.getBiathlonAthlete().getAthleteNumber());
            if (i >= 1) {
                Duration currentTime = sortedResults.get(i).getTimeWithPenalties();
                Duration previousTime = sortedResults.get(i - 1).getTimeWithPenalties();
                Assertions.assertTrue(currentTime.compareTo(previousTime) > 0);
            }
        }
    }

    private static Duration getDuration(String raceTime) {
        String[] raceTimeElements = raceTime.split(":");
        Duration duration = Duration.ZERO;
        duration = duration.plusMinutes(Long.parseLong(raceTimeElements[0]));
        duration = duration.plusSeconds(Long.parseLong(raceTimeElements[1]));
        return duration;
    }
}
