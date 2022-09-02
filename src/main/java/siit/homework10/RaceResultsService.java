package siit.homework10;

import siit.homework10.dataAccess.RaceResultsDao;
import siit.homework10.dataModel.RaceResult;

import java.util.List;

/**
 * The service deals with race results.
 */
public class RaceResultsService {
    private RaceResultsDao raceResultsDao;

    /**
     * Creates a race result service given a data access object.
     *
     * @param dao the dao
     */
    public RaceResultsService(RaceResultsDao dao) {
        this.raceResultsDao = dao;
    }

    /**
     * Gets the results in the sorted order. See {@link TimeWithPenaltiesComparator} for order.
     *
     * @return sorted results
     */
    public List<RaceResult> getSortedResults() {
        List<RaceResult> raceResults = raceResultsDao.readResults();
        raceResults.sort(new TimeWithPenaltiesComparator());
        return raceResults;
    }
}
