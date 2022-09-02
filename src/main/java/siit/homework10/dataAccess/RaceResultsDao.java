package siit.homework10.dataAccess;

import siit.homework10.dataModel.RaceResult;

import java.util.List;

/**
 * This is a race results data access object.
 */
public interface RaceResultsDao {
    /**
     * Reads the race results.
     *
     * @return a list of race results
     */
    List<RaceResult> readResults();
}
