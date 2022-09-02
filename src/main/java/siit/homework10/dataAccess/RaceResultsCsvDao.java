package siit.homework10.dataAccess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import siit.homework10.dataModel.RaceResult;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a  {@link RaceResultsDao} that reads data from a csv file.
 */
public class RaceResultsCsvDao implements RaceResultsDao {
    private static final Logger log = LogManager.getLogger(RaceResultsCsvDao.class);
    private String fileName;
    private RaceResultParser lineParser;

    /**
     * Creates a data access object given a fileName
     *
     * @param fileName the file from where it reads the data
     */
    public RaceResultsCsvDao(String fileName) {
        this.fileName = fileName;
        this.lineParser = new RaceResultParser();
    }

    /**
     * Reads the race results from the file.
     * If any exception occurs during file parsing (FileNotFoundException, IOException) it will return an empty list.
     *
     * @return a list of {@link RaceResult}
     */
    @Override
    public List<RaceResult> readResults() {
        List<RaceResult> raceResultList = new ArrayList<>();
        try {
            FileReader in = new FileReader(fileName);
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                raceResultList.add(lineParser.parseRaceResult(line));
            }
        } catch (FileNotFoundException e) {
            // user interface handling
            System.out.println("File not found");
            // logging exception
            log.error("File not found", e);
        } catch (IOException e) {
            System.out.println("Cannot read file");
            log.error("Cannot read file", e);
        }
        return raceResultList;
    }
}
