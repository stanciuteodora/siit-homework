package siit.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


class FileProcessorTest {
    @Test
    public void TC1Test() throws IOException {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC1.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC1.txt");
        Path expectedOutputPath = Path.of("src/test/resources/homework12/peopleOut_TC1_expected.txt");
        FileProcessor processor = new FileProcessor(6, inputPath, outputPath);

        // test execution
        processor.processFile();

        //assertions
//        Assertions.assertTrue(filesCompareByLine(outputPath, expectedOutputPath));
        Assertions.assertEquals(Files.mismatch(outputPath, expectedOutputPath), -1L);
    }
    @Test
    public void inputFileEmptyTest() throws IOException {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC2.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC2.txt");
        Path expectedOutputPath = Path.of("src/test/resources/homework12/peopleOut_TC2_expected.txt");
        FileProcessor processor = new FileProcessor(6, inputPath, outputPath);

        // test execution
        processor.processFile();

        //assertions
        Assertions.assertEquals(Files.mismatch(outputPath, expectedOutputPath), -1L);
    }

    @Test
    public void inputFileNotExistTest() {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC0.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC1.txt");
        FileProcessor processor = new FileProcessor(6, inputPath, outputPath);

        //assertions
        Assertions.assertThrows(RuntimeException.class, () -> processor.processFile());
    }

    @Test
    public void filter0TargetMonthTest(){
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC1.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC1.txt");
        FileProcessor processor = new FileProcessor(13, inputPath, outputPath);

        //assertions
        Assertions.assertThrows(RuntimeException.class, () -> processor.processFile());
    }
    @Test
    public void filterOtherTargetMonthTest() throws IOException {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC1.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC1.txt");
        Path expectedOutputPath = Path.of("src/test/resources/homework12/peopleOut_TC3_expected.txt");
        FileProcessor processor = new FileProcessor(3, inputPath, outputPath);

        // test execution
        processor.processFile();

        //assertions
        Assertions.assertEquals(Files.mismatch(outputPath, expectedOutputPath), -1L);
    }

    @Test
    public void filterTargetMonthNotInInputFileTest() throws IOException {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC1.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC1.txt");
        Path expectedOutputPath = Path.of("src/test/resources/homework12/peopleOut_TC4_expected.txt");
        FileProcessor processor = new FileProcessor(4, inputPath, outputPath);

        // test execution
        processor.processFile();

        //assertions
        Assertions.assertEquals(Files.mismatch(outputPath, expectedOutputPath), -1L);
    }

    @Test
    public void sortAlreadyInOrderTest() throws IOException {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC5.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC5.txt");
        Path expectedOutputPath = Path.of("src/test/resources/homework12/peopleOut_TC5_expected.txt");
        FileProcessor processor = new FileProcessor(6, inputPath, outputPath);

        // test execution
        processor.processFile();

        //assertions
        Assertions.assertEquals(Files.mismatch(outputPath, expectedOutputPath), -1L);
    }

    @Test
    public void sortOnePersonTest() throws IOException {
        // data preparation
        Path inputPath = Path.of("src/test/resources/homework12/peopleIn_TC6.txt");
        Path outputPath = Path.of("src/test/resources/homework12/peopleOut_TC6.txt");
        Path expectedOutputPath = Path.of("src/test/resources/homework12/peopleOut_TC6_expected.txt");
        FileProcessor processor = new FileProcessor(6, inputPath, outputPath);

        // test execution
        processor.processFile();

        //assertions
        Assertions.assertEquals(Files.mismatch(outputPath, expectedOutputPath), -1L);
    }

//    public static Boolean filesCompareByLine(Path path1, Path path2) throws IOException {
//        try (BufferedReader bf1 = Files.newBufferedReader(path1);
//             BufferedReader bf2 = Files.newBufferedReader(path2)) {
//
//            String line1 = "", line2 = "";
//            while ((line1 = bf1.readLine()) != null) {
//                line2 = bf2.readLine();
//                if (!line1.equals(line2)) {
//                    return false;
//                }
//            }
//            return bf2.readLine() == null;
//        }
//    }

}