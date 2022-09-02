package siit.homework10;

import siit.homework10.dataAccess.RaceResultsCsvDao;
import siit.homework10.dataAccess.RaceResultsDao;
import siit.homework10.dataModel.RaceResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RaceResultsDao raceResultsDao = new RaceResultsCsvDao("athletes.csv");
        RaceResultsService raceResultsService = new RaceResultsService(raceResultsDao);
        List<RaceResult> sortedResults = raceResultsService.getSortedResults();
        System.out.println(sortedResults);
        System.out.println("Winner - " + sortedResults.get(0));
        System.out.println("Runner-up - " + sortedResults.get(1));
        System.out.println("Third Place - " + sortedResults.get(2));
    }
}
