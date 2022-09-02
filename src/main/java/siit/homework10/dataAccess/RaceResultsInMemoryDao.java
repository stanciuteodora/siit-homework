package siit.homework10.dataAccess;

import siit.homework10.dataModel.RaceResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * not implemented
 */
public class RaceResultsInMemoryDao implements RaceResultsDao {
    private String fileContent;

    private RaceResultParser lineParser;

    public RaceResultsInMemoryDao(String fileContent) {
        this.fileContent = fileContent;
        this.lineParser = new RaceResultParser();
    }

    @Override
    public List<RaceResult> readResults() {
        InputStream targetStream = new ByteArrayInputStream(fileContent.getBytes());
        // todo implement parsing this stream -> I only used the file parser but
        return null;
    }
}
