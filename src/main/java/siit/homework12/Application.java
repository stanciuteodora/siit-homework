package siit.homework12;

import java.nio.file.Path;


public class Application {

    public static void main(String[] args) {
//        String inputFileName = args[0];                 /*src/main/resources/peopleIn.csv*/
//        String outputFileName = args[2];                /* src/main/resources/peopleOut.csv */
//        Integer targetMonth = Integer.valueOf(args[1]); /* 6 */

        String inputFileName = "src/main/resources/homework12/peopleIn.csv";
        String outputFileName = "src/main/resources/homework12/peopleOut.csv";
        Integer targetMonth = 6;

        Path inputPath = Path.of(inputFileName);
        Path outputPath = Path.of(outputFileName);

        FileProcessor processor = new FileProcessor(targetMonth, inputPath, outputPath);
        processor.processFile();
    }


}
