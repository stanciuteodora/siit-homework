package siit.homework06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a calculator capable of computing a metric distance value from an expression that contains different
 * scales and systems
 * Output is specified by the user.
 * <p>
 * Only Addition and subtraction is allowed.
 * <p>
 * Supported formats: mm, cm, dm, m, km.
 * <p>
 * Output is returned in lowest unit.
 * <p>
 * Ignore groups where the value characters are not numbers, the unit of measure is missing or the format is not
 * supported. If there are 2 signs for a group, the first one is ignored.
 */
public class SumInMillimeters {
    /*
     * Pattern explained
     * (\\+|\\-)      -> plus or minus character (\\ escapes the character => it refers to the actual character not the regex operator)
     * (\\+|\\-)?     -> repeats 0 or 1 times
     * ( +)           -> character space " " repeats 0 or more times
     * (\\d+)         -> there's a digit that repeats 1 or more times
     * (mm|cm|...|m)  -> one of the following sets of characters mm or cm or dm or km or m
     */

    private static String PATTERN_REGEX = "(\\+|\\-)?( *)(\\d+)( *)(mm|cm|dm|km|m)";

    /**
     * Parses the expression received and computes the metric distance value from the expression that contains
     * different scales and systems.
     *
     * @param string format for the string: addition and subtraction; unit of measure: mm, cm, dm, m, km;
     * @return the sum
     */
    public int sum(String string) {

        Pattern pattern = Pattern.compile(PATTERN_REGEX);
        Matcher matcher = pattern.matcher(string);

        int sum = 0;
        while (matcher.find()) {
            String group = matcher.group();
            String unitOfMeasure = extractFromString(group, "(mm|cm|dm|km|m)", null);
            String number = extractFromString(group, "(\\d+)", null);
            String sign = extractFromString(group, "(\\+|\\-)?", "+");
            sum += transformToMillimeters(unitOfMeasure, number, sign);
        }
        System.out.println("Sum: " + sum + " mm");
        return sum;
    }

    /**
     * Extracts a substring from the expression.
     *
     * @param stringToBeSearched the expression
     * @param patternString      the pattern for parsing
     * @param defaultData        in case not found it returns the default data
     * @return the substring
     */
    private String extractFromString(String stringToBeSearched, String patternString, String defaultData) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher unitMatcher = pattern.matcher(stringToBeSearched);
        unitMatcher.find();
        String group = unitMatcher.group(1);
        if (group == null) {
            return defaultData;
        }

        return group;
    }

    /**
     * Transforms the value from any ( km, m, dm, cm, mm) unit of measure to millimeters.
     *
     * @param unitOfMeasure the unit of measure: km, m, dm, cm, mm
     * @param number        the number
     * @param sign          the sign
     * @return the value in millimeters
     */
    private int transformToMillimeters(String unitOfMeasure, String number, String sign) {
        int distance = Integer.parseInt(number);
        switch (unitOfMeasure) {
            case "km":
                distance = distance * 1000000;
                break;
            case "m":
                distance = distance * 1000;
                break;
            case "dm":
                distance = distance * 100;
                break;
            case "cm":
                distance = distance * 10;
                break;
        }
        if (sign.equals("-")) {
            distance = distance * -1;
        }
        return distance;
    }


}
