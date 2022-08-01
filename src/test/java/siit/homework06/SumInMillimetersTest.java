package siit.homework06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumInMillimetersTest {
    /**
     * Tests an expression where all terms are separated by space;
     * test data: "10 cm + 1 m - 10 mm";
     * expected result: 1090;
     */
    @Test
    public void test_sum_expression_homework() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "10 cm + 1 m - 10 mm";
        Assertions.assertEquals(1090, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the terms are not separated by space;
     * test data: "10mm+15km+1m-10dm";
     * expected result: 15000010;
     */
    @Test
    public void test_sum_expression_without_space() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "10mm+15km+1m-10dm";
        Assertions.assertEquals(15000010, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the value and the unit of measure are not separated by space, the sign is separated
     * by space from the value and the unit of measure; the expressions begins and ends with space
     * test data: "  10m + 15mm - 1m + 1dm  ";
     * expected result: 9115;
     */
    @Test
    public void test_sum_expression_space_before_and_after_sign() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "  10m + 15mm - 1m + 1dm  ";
        Assertions.assertEquals(9115, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the format is: space, sign, value, unit of measure;
     * test data: " +10cm +1m +15mm";
     * expected result: 1115;
     */
    @Test
    public void test_sum_expression_space_before_sign() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = " +10cm +1m +15mm";
        Assertions.assertEquals(1115, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the sign and the value are not separated by space, the unit of measure is separated
     * by space from the sign and the value;
     * test data: -10 cm +1 m -10 mm";
     * expected result: 890;
     */
    @Test
    public void test_sum_expression_space_before_and_after_unit_of_measure() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "-10 cm +1 m -10 mm";
        Assertions.assertEquals(890, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where are 2 signs one after the other;
     * test data: "-10 cm -+1 m --10 mm";
     * expected result: 890;
     */
    @Test
    public void test_sum_expression_2_adjacent_signs() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "-10 cm -+1 m --10 mm";
        Assertions.assertEquals(890, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the value has other characters than numbers;
     * test data: "-1o cm -+1 m --10 mm";
     * expected result: 990;
     */
    @Test
    public void test_sum_expression_wrong_number_format() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "-1o cm -+1 m --10 mm";
        Assertions.assertEquals(990, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the unit of measure has other unit of measure than mm, cm, dm, m, km;
     * test data: "-10 gm -+1 m --10 mm";
     * expected result: 990;
     */
    @Test
    public void test_sum_expression_wrong_unit_of_measure_format() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "-10 gm -+1 m --10 mm";
        Assertions.assertEquals(990, sumInMIllimeters.sum(ex));
    }

    /**
     * Tests an expression where the unit of measure is missing;
     * test data: "-10  -+1 m --10 mm";
     * expected result: 990;
     */
    @Test
    public void test_sum_expression_missing_unit_of_measure_format() {
        SumInMillimeters sumInMIllimeters = new SumInMillimeters();
        String ex = "-10  -+1 m --10 mm";
        Assertions.assertEquals(990, sumInMIllimeters.sum(ex));
    }
}
