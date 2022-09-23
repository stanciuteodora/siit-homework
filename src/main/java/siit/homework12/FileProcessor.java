package siit.homework12;

import siit.homework12.dataModel.Person;
import siit.homework12.dataModel.PersonParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * This is a file processor
 */
public class FileProcessor {
    private Integer targetMonth;
    private Path inputPath;
    private Path outputPath;
    private PersonParser parser;

    /**
     * Creates a file processor
     *
     * @param targetMonth the target month
     * @param inputPath   the input path
     * @param outputPath  the output path
     */

    public FileProcessor(Integer targetMonth, Path inputPath, Path outputPath) {
        this.targetMonth = targetMonth;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.parser = new PersonParser();
    }

    /**
     * Parses the data from the input path,
     * filters it by target month
     * sorts it by last name
     * writes it to the output file
     *
     * If exception occurs(IOException) it will throw RuntimeException.
     */
    public void processFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(outputPath)));
             Stream<String> lines = Files.lines(inputPath)) {
            lines.map(parser::parsePerson)
                    .filter(person -> person.getDateOfBirth().getMonth().equals(Month.of(targetMonth)))
                    .sorted(Comparator.comparing(Person::getLastName))
                    .forEach(person -> writePerson(writer, person));
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writePerson(BufferedWriter writer, Person person) {
        try {
            writer.write(person.getFirstName());
            writer.write(" ");
            writer.write(person.getLastName());
            writer.newLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public Integer getTargetMonth() {
        return targetMonth;
    }

    public Path getInputPath() {
        return inputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }
}
